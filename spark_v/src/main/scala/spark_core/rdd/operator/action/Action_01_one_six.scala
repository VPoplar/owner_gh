package spark_core.rdd.operator.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Action_01_one_six {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Action")
    val sc: SparkContext = new SparkContext(conf)
    // TODO 调用方法
    reduce()
    collect()
    count()
    first()
    take()
    takeOrdered()
    // TODO 关闭资源
    sc.stop()
    // TODO 1 reduce 算子-聚合
    def reduce(): Unit = {
      val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4))
      val result: Int = rdd.reduce(_+_)
      println(result)
    }
    // TODO 2 collect 算子-会将不同分区的数据按照分区顺序采集到Driver端内存中，形成数组
    def collect(): Unit = {
      val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4))
      val rdd_re: Array[Int] = rdd.collect()
      println(rdd_re.mkString(","))
    }
    // TODO 3 count 算子-统计数据源中数据的个数
    def count(): Unit = {
      val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4))
      val re: Long = rdd.count()
      println(re)
    }
    // TODO 4 first 算子-取数据源中第一个数据
    def first(): Unit = {
      val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4))
      val re: Int = rdd.first()
      println(re)
    }
    // TODO 5 take 算子-取数据源中N个数据
    def take(): Unit = {
      val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4))
      val re: Array[Int] = rdd.take(3)
      println(re.mkString(","))
    }
    // TODO 6 takeOrdered 算子-数据排序后，取数据源中N个数据
    def takeOrdered(): Unit = {
      val rdd: RDD[Int] = sc.makeRDD(List(1,2,4,3))
      val re: Array[Int] = rdd.takeOrdered(3)
      println(re.mkString(","))
    }


  }
}
