package rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

// repartition : 一般用于扩大分区：默认shuffle
object Transform_11_repartition {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    coalesce()
    println("-----------------")
    // TODO 关闭资源
    sc.stop()

    // TODO 执行逻辑
    def coalesce(): Unit = {
      val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4,5,6),2)
      val rdd_result: RDD[Int] = rdd.repartition(3)
      rdd_result.saveAsTextFile("output")
    }




  }
}
