package spark_core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

// 让数据显示分区
object Transform_03_mapPartitionsWithIndex{
  def main(args: Array[String]): Unit = {
    // TODO 创建环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)
    // TODO 创建数据
    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4,5,6))
    val map_rdd = rdd.mapPartitionsWithIndex(
      (index, iter) => {
        // 1,   2,    3,   4
        //(0,1)(2,2),(4,3),(6,4)
        iter.map(
          num => {
            (index, num)
          }
        )
      }
    )
    map_rdd.collect().foreach(println)

    sc.stop()
  }
}
