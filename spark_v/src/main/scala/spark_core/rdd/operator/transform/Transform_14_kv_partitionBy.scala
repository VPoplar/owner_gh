package spark_core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}


object Transform_14_kv_partitionBy {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    partitionBy()
    println("-----------------")
    //sortBy_test()
    // TODO 关闭资源
    sc.stop()

    // TODO partitionBy: 对数据按照指定的规则进行分区；区别于coalesce和repartition（只是对分区数量进行改变）
      def partitionBy(): Unit = {
        val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4),2)
        val kv_rdd: RDD[(Int, Int)] = rdd.map((_,1))
        kv_rdd.partitionBy(new HashPartitioner(2)).saveAsTextFile("output")

      }




  }
}
