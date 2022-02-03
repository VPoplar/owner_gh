package rdd.operator.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Action_03_countByKey_countByValue {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Action")
    val sc: SparkContext = new SparkContext(conf)
    // TODO 调用方法
    countByKey()
    countByValue()
    // TODO 关闭资源
    sc.stop()
    // TODO 9 countByKey 算子-需要的是kv类型数据，统计key出现的次数
    def countByKey(): Unit = {
      val rdd: RDD[(String, Int)] = sc.makeRDD(List(("a",1),("a",1),("b",1),("c",1)))
      val re: collection.Map[String, Long] = rdd.countByKey()
      println(re)
    }
    // TODO 10 countByValue 算子-统计数据的个数,最后的结果是一个map
    def countByValue(): Unit = {
      // val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4))
      val rdd: RDD[(String, Int)] = sc.makeRDD(List(("a",1),("a",1),("b",1),("c",1)))
      val re: collection.Map[(String, Int), Long] = rdd.countByValue()
      println(re)
    }


  }
}
