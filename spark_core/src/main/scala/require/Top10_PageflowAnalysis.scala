package require

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

// TODO 需求3 页面单跳转换率统计
object Top10_PageflowAnalysis{
  def main(args: Array[String]): Unit = {

    // TODO : Top10热门品类
    val sparConf = new SparkConf().setMaster("local[*]").setAppName("HotCategoryTop10Analysis")
    val sc = new SparkContext(sparConf)
    val actionRDD = sc.textFile("datas/user_visit_action.txt")
    val actionDataRDD: RDD[UserVisitAction] = actionRDD.map(
      action => {
        val datas: Array[String] = action.split("_")
        UserVisitAction(
          datas(0),
          datas(1).toLong,
          datas(2),
          datas(3).toLong,
          datas(4),
          datas(5),
          datas(6).toLong,
          datas(7).toLong,
          datas(8),
          datas(9),
          datas(10),
          datas(11),
          datas(12).toLong
        )
      }
    )
    actionDataRDD.cache()
    // TODO 对指定的页面连续跳转进行统计
    // 1-2,2-3,3-4,4-5,5-6,6-7
    val ids: List[Long] = List[Long](1,2,3,4,5,6,7)
    val okflowIds: List[(Long, Long)] = ids.zip(ids.tail)
    // 计算分母 不需要最后一个页面的统计量，因为没有转换，可以用init()方法
    val pageidToCountMap: Map[Long, Long] = actionDataRDD.filter(
      action => {
        ids.init.contains(action.page_id)
      }
    ).map(
      action => {
        (action.page_id, 1L)
      }
    ).reduceByKey(_ + _).collect().toMap

    // 计算分子
    // 根据session分组
    val sessionRDD: RDD[(String, Iterable[UserVisitAction])] = actionDataRDD.groupBy(_.session_id)
    // 分组后根据访问时间进行排序
    val mvRDD: RDD[(String, List[((Long, Long), Int)])] = sessionRDD.mapValues(
      iter => {
        val sortList: List[UserVisitAction] = iter.toList.sortBy(_.action_time)
        // 【1，2，3，4】
        // 【1，2】，【2，3】，【3，4】
        // 【1-2，2-3，3-4】
        // Sliding : 滑窗
        // 【1，2，3，4】
        // 【2，3，4】
        // zip : 拉链
        val flowIds: List[Long] = sortList.map(_.page_id)
        //tail 函数取列表中除掉开头元素中的其他所有元素
        val pageflowIds: List[(Long, Long)] = flowIds.zip(flowIds.tail)
        // 将不合法的页面进行过滤
        pageflowIds.filter(
          t => {
            okflowIds.contains(t)
          }
        ).map((_, 1))
      }
    )
    // ((1,2),1)
    val flatRDD: RDD[((Long, Long), Int)] = mvRDD.map(_._2).flatMap(list => list)
    val dataRDD: RDD[((Long, Long), Int)] = flatRDD.reduceByKey(_+_)
    // TODO 计算单跳转换率
    // 分子除以分母
    dataRDD.foreach{
      case ((pageid1,pageid2),sum) => {
        val den: Long = pageidToCountMap.getOrElse(pageid1,0L)  //基本页面的数据量
        println(s"页面${pageid1}跳转到${pageid2}的单跳转换率为:" + sum.toDouble/den)
      }
    }



    // 关闭资源
    sc.stop()
  }

  //用户访问动作表
  case class UserVisitAction(
                              date: String,//用户点击行为的日期
                              user_id: Long,//用户的ID
                              session_id: String,//Session的ID
                              page_id: Long,//某个页面的ID
                              action_time: String,//动作的时间点
                              search_keyword: String,//用户搜索的关键词
                              click_category_id: Long,//某一个商品品类的ID
                              click_product_id: Long,//某一个商品的ID
                              order_category_ids: String,//一次订单中所有品类的ID集合
                              order_product_ids: String,//一次订单中所有商品的ID集合
                              pay_category_ids: String,//一次支付中所有品类的ID集合
                              pay_product_ids: String,//一次支付中所有商品的ID集合
                              city_id: Long
                            )//城市 id

}
