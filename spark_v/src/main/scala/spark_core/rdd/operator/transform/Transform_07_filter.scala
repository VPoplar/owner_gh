package spark_core.rdd.operator.transform

import java.text.SimpleDateFormat
import java.util.Date

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

// filter 过滤函数
object Transform_07_filter {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)
    filter()
    println("-----------------")
    filter_test()
    sc.stop()
    // 1 取集合中的奇数
    def filter(): Unit = {
      val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4))
      val rdd_filter: RDD[Int] = rdd.filter(num => num%2 != 0)
      rdd_filter.collect().foreach(println)
    }
    // 2 小功能：从服务器日志数据 apache.log 中获取 2015 年 5 月 17 日的请求路径
    def filter_test(): Unit = {
      val rdd: RDD[String] = sc.textFile("datas\\apache.log")
      val rdd_result: RDD[String] = rdd.filter(
        line => {
          val data: Array[String] = line.split(" ")
          val time: String = data(3)
          time.startsWith("17/05/2015")
        }
      )
      rdd_result.collect().foreach(println)
    }



  }
}
