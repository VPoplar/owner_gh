package spark_core.accumulator

import org.apache.spark.rdd.RDD
import org.apache.spark.util.LongAccumulator
import org.apache.spark.{SparkConf, SparkContext}

object Acc_03_base {
  def main(args: Array[String]): Unit = {
    //准备环境
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc: SparkContext = new SparkContext(sparkConf)
    // 分区内计算，分区间也计算
    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4))
    // 获取系统累加器
    // spark默认提供了简单数据聚合的累加器
    val sumAcc: LongAccumulator = sc.longAccumulator("num")
    val map_rdd: RDD[Int] = rdd.map(
      num => {
        // 使用累加器
        sumAcc.add(num)
        num
      }
    )
    // 获取累加器的值可能会出现的问题：少加或者多加
    // 少加：转换算子中调用累加器，如果没有行动算子的话，那么不会执行
    // 多加：转换算子中调用累加器,如果有遇到多个行动算子，则可能会出现多加的情况
    map_rdd.collect()
    map_rdd.collect()
    println(sumAcc.value)


    sc.stop()
  }

}
