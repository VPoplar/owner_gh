package accumulator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Acc_01_base {
  def main(args: Array[String]): Unit = {
    //准备环境
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc: SparkContext = new SparkContext(sparkConf)
    // 分区内计算，分区间也计算
    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4))
    // val i: Int = rdd.reduce(_+_)
    //println(i)
    var sum = 0
    rdd.foreach(
      num => {
        sum += num
      }
    )
    println("sum= " + sum)
    sc.stop()
  }

}
