package rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

// flatMap : 将处理的数据进行扁平化后再进行映射处理，所以算子也称之为扁平映射
object Transform_02_mapPartitions_prc {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)
    flatMap()
    sc.stop()


    def flatMap(): Unit = {
      // TODO 创建数据，处理集合
      val rdd: RDD[List[Int]] = sc.makeRDD(List(
        List(1,2,3),List(4,5,6))
      )
      val rdd_result = rdd.flatMap(
        list => {
          list
        }
      )
      println("-------集合处理------")
      rdd_result.collect().foreach(println)
      // TODO 创建数据，处理字符串
      val rdd_s: RDD[String] = sc.makeRDD(List(
        "hello scala", "hello spark")
      )
      rdd_s.flatMap(
        s => {
          s.split(" ")
        }
      )
      println("------字符串处理-------")
      rdd_s.collect().foreach(println)

      val rdd_other = sc.makeRDD(List(List(1,2),3,List(4,5)))
      val rdd3 = rdd_other.flatMap(
        data => {
          // 用到了模式匹配
          data match {
            case list:List[_] => list
            case dat => List(dat)
          }
        }
      )
      println("------不规则处理-------")
      rdd3.collect().foreach(println)
    }
  }


}
