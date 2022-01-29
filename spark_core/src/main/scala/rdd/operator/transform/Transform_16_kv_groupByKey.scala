package rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
// reduceByKey 和 groupByKey 的区别
// 相同点-reduceByKey都会落盘
// 不同点-reduceByKey 在shuffle之前会先对分区内的数据处理(预聚合),能够减少落盘的数据量；
//                    分组聚合功能
// 不同点-groupByKey  只是分组，没有聚合

object Transform_16_kv_groupByKey {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    groupByKey()
    println("-----------------")
    //sortBy_test()
    // TODO 关闭资源
    sc.stop()

    // TODO groupByKey: 对数据按照指定的规则进行分区；区别于coalesce和repartition（只是对分区数量进行改变）
    // 将数据元中的数据按照key进行分组，并把相同key的value进行拼接起来形成一个value的集合
    // 但是groupby中的Key可以自己指定
    //
      def groupByKey(): Unit = {
        val rdd = sc.makeRDD(List(
          ("a", 1), ("a", 2), ("a", 3), ("b", 4)
        ))
        val groupByKey_rdd: RDD[(String, Iterable[Int])] = rdd.groupByKey()
        groupByKey_rdd.collect().foreach(println)
        // (a,CompactBuffer(1, 2, 3))
        // (b,CompactBuffer(4))
        println("--------------------------------")
        val groupby_rdd: RDD[(String, Iterable[(String, Int)])] = rdd.groupBy(t=>t._1)
        groupby_rdd.collect().foreach(println)


      }




  }
}
