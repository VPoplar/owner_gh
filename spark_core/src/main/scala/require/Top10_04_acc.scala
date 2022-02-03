package require

import org.apache.spark.rdd.RDD
import org.apache.spark.util.AccumulatorV2
import org.apache.spark.{SparkConf, SparkContext}
import scala.collection.mutable

// TODO 优化用累加器代替reduceByKey，这样就不会产生shuffle
object Top10_04_acc {
  def main(args: Array[String]): Unit = {
    // TODO : Top10热门品类
    // TODO : Top10热门品类
    val sparConf = new SparkConf().setMaster("local[*]").setAppName("HotCategoryTop10Analysis")
    val sc = new SparkContext(sparConf)

    // Q : 存在大量的shuffle操作（reduceByKey）


    // 1. 读取原始日志数据
    val actionRDD = sc.textFile("datas/user_visit_action.txt")
    actionRDD.cache()
    // 注册累加器
    val acc = new HotCategoryAccumulator
    sc.register(acc,"HotCategoryAccumulator")
    // 2 将数据转换结构
    actionRDD.foreach(
      action => {
        val datas = action.split("_")
        if (datas(6) != "-1") {
          // 点击的场合
          acc.add(datas(6),"click")
        } else if (datas(8) != "null"){
          // 下单的场合
          val ids = datas(8).split(",")
          ids.foreach(
            id => {
              acc.add(id,"order")
            }
          )
        } else if (datas(10) != "null"){
      // 下单的场合
      val ids = datas(10).split(",")
      ids.foreach(
        id => {
          acc.add(id,"pay")
        }
      )
    }
      }
    )
    val accVal: mutable.Map[String, HotCategory] = acc.value
    val categories: mutable.Iterable[HotCategory] = accVal.map(_._2)
    // 3 进行排序,转换成集合再进行自定义排序
    val sort: List[HotCategory] = categories.toList.sortWith(
      (t1, t2) => {
        if (t1.clickCnt > t2.clickCnt) {
          true
        } else if (t1.clickCnt == t2.clickCnt) {
          if (t1.orderCnt > t2.orderCnt) {
            true
          } else if (t1.orderCnt == t2.orderCnt) {
            t1.payCnt > t2.payCnt
          } else {
            false
          }
        } else {
          false
        }
      }
    )
    // 4 将采集结果打印出来
    sort.take(10).foreach(println)


    sc.stop()
  }
  case class HotCategory( cid:String, var clickCnt : Int, var orderCnt : Int, var payCnt : Int )
  /**
    * 自定义累加器
    * 1. 继承AccumulatorV2，定义泛型
    *    IN : ( 品类ID, 行为类型 )
    *    OUT : mutable.Map[String, HotCategory]
    * 2. 重写方法（6）
    */
  class HotCategoryAccumulator extends AccumulatorV2[(String, String), mutable.Map[String, HotCategory]]{
    private val hcMap = mutable.Map[String, HotCategory]()

    override def isZero: Boolean = {
      hcMap.isEmpty
    }

    override def copy(): AccumulatorV2[(String, String), mutable.Map[String, HotCategory]] = {
      new HotCategoryAccumulator()
    }

    override def reset(): Unit = {
      hcMap.clear()
    }
    // 进行累加
    override def add(v: (String, String)): Unit = {
      val cid = v._1
      val actionType = v._2
      val category: HotCategory = hcMap.getOrElse(cid,HotCategory(cid,0,0,0))
      if (actionType == "click"){
        category.clickCnt += 1
      } else if (actionType == "order"){
        category.orderCnt += 1
      } else if (actionType == "pay"){
        category.payCnt += 1
      }
      hcMap.update(cid,category)
    }
    // 进行合并
    override def merge(other: AccumulatorV2[(String, String), mutable.Map[String, HotCategory]]): Unit = {
      val map1: mutable.Map[String, HotCategory] = this.hcMap
      val map2: mutable.Map[String, HotCategory] = other.value
      map2.foreach{
        case (cid,hc) => {
          val category: HotCategory = map1.getOrElse(cid,HotCategory(cid,0,0,0))
          category.clickCnt += hc.clickCnt
          category.orderCnt += hc.orderCnt
          category.payCnt += hc.payCnt
          map1.update(cid,category)
        }
      }
    }

    override def value: mutable.Map[String, HotCategory] = hcMap
  }

}
