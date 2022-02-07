package spark_core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Transform_24_case {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)
    // 1. 获取原始数据：时间戳，省份，城市，用户，广告
    val rdd: RDD[String] = sc.textFile("datas\\agent.log")
    // 2. 将原始数据进行结构的转换。方便统计
    //    时间戳，省份，城市，用户，广告
    //    =>
    //    ( ( 省份，广告 ), 1 )
    val map_rdd: RDD[((String, String), Int)] = rdd.map(
      line => {
        val datas: Array[String] = line.split(" ")
        ((datas(1), datas(4)), 1)
      }
    )
    // 3. 将转换结构后的数据，进行分组聚合
    //    ( ( 省份，广告 ), 1 ) => ( ( 省份，广告 ), sum )
    val agg_rdd: RDD[((String, String), Int)] = map_rdd.reduceByKey(_+_)
    // 4. 将聚合的结果进行结构的转换
    //    ( ( 省份，广告 ), sum ) => ( 省份, ( 广告, sum ) )
    val tra_rdd: RDD[(String, (String, Int))] = agg_rdd.map {
      case ((pro, ad), sum) => {
        (pro, (ad, sum))
      }
    }
    // 5. 将转换结构后的数据根据省份进行分组
    //    ( 省份, 【( 广告A, sumA )，( 广告B, sumB )】 )
    val gr_rdd: RDD[(String, Iterable[(String, Int)])] = tra_rdd.groupByKey()
    // 6. 将分组后的数据组内排序（降序），取前3名
    val result_rdd: RDD[(String, List[(String, Int)])] = gr_rdd.mapValues(
      iter => {
        iter.toList.sortBy(_._2)(Ordering.Int.reverse).take(3)
      }
    )
    result_rdd.collect().foreach(println)
    // TODO 关闭资源
    sc.stop()

  }
}
