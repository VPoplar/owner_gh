package rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

// distinct : 去重
object Transform_09_distinct {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    distinct()
    println("-----------------")
    // TODO 关闭资源
    sc.stop()

    // TODO 执行逻辑
    def distinct(): Unit = {
      val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,2,3,4,5))
      val rdd_result: RDD[Int] = rdd.distinct()
      rdd_result.collect().foreach(println)
    }




  }
}
