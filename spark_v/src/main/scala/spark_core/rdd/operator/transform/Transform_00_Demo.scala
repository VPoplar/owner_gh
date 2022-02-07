package spark_core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
// 从服务器日志数据 apache.log 中获取用户请求 URL 资源路径
object Transform_00_Demo {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)
    // TODO 创建数据
    val rdd: RDD[String] = sc.textFile("datas/apache.log")

    val mapRDD: RDD[String] = rdd.map(
      line => {
        val arr: Array[String] = line.split(" ")
        arr(6)
      }
    )
    // 打印结果
    mapRDD.collect().foreach(println)
    sc.stop()
  }
}
