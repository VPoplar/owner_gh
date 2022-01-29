package rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

// mapPartitions : 小功能-获取每个分区数据的最大值
object Transform_04_flatMap{
  def main(args: Array[String]): Unit = {
    // TODO 创建环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)
    // TODO 创建数据
    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4),2)
    val map_rdd: RDD[Int] = rdd.mapPartitions(
      iter => {
        // 【1，2】，【3，4】
        // 【2】，【4】
      List(iter.max).iterator
      }
    )
    map_rdd.collect().foreach(println)

    sc.stop()
  }
}
