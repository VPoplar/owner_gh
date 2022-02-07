package spark_core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Transform_01_map {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)
    // TODO 创建数据
    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4))
    // 转换函数
   /* def mapFunction(num: Int): Int = {
      num * 2
    }*/

    // val mapRDD: RDD[Int] = spark_core.rdd.map(mapFunction)
    // 通过匿名函数来实现-更简单
    // val mapRDD: RDD[Int] = spark_core.rdd.map((num:Int)=>{num * 2})
    val mapRDD: RDD[Int] = rdd.map(_*2)
    // 打印结果
    mapRDD.collect().foreach(println)
    sc.stop()
  }
}
