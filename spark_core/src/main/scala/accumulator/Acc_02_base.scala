package accumulator

import org.apache.spark.rdd.RDD
import org.apache.spark.util.LongAccumulator
import org.apache.spark.{SparkConf, SparkContext}

object Acc_02_base {
  def main(args: Array[String]): Unit = {
    //准备环境
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc: SparkContext = new SparkContext(sparkConf)
    // 分区内计算，分区间也计算
    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4))
    // 获取系统累加器
    // spark默认提供了简单数据聚合的累加器
    val sumAcc: LongAccumulator = sc.longAccumulator("num")
    // sc.doubleAccumulator
    // sc.collectionAccumulator
    rdd.foreach(
      num => {
        // 使用累加器
        sumAcc.add(num)
      }
    )
    // 获取累加器的值
    println(sumAcc.value)


    sc.stop()
  }

}
