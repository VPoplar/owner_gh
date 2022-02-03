package rdd.operator.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Action_02_aggregate {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Action")
    val sc: SparkContext = new SparkContext(conf)
    // TODO 调用方法
    aggregate()
    fold()
    // TODO 关闭资源
    sc.stop()
    // TODO 7 aggregate 算子-聚合
    // aggregateByKey中的初始值只参加分区内计算，不会参加分区间计算
    // aggregate中的初始值不仅参加分区内计算，还会参加分区间计算
    def aggregate(): Unit = {
      val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4),2)
      val re: Int = rdd.aggregate(10)(_+_,_+_)
      println(re)
      //10 + 13 + 17 = 40
    }
    // TODO 8 fold 算子-aggregate分区内和分区间的计算逻辑是一样的就可以用该算子

    def fold(): Unit = {
      val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4),2)
      val re: Int = rdd.fold(10)(_+_)
      println(re)
      //10 + 13 + 17 = 40
    }


  }
}
