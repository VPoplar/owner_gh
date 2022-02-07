package spark_core.rdd.operator.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Action_05_foreach {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Action")
    val sc: SparkContext = new SparkContext(conf)
    // TODO 调用方法
    foreach()

    // TODO 关闭资源
    sc.stop()
    // TODO 14 foreach
    /*
    算子：（Operator）操作
    RDD的方法和scala中集合对象的方法不一样
      集合对象的方法都是在同一个节点中的内存中完成；而RDD的方法可以将计算逻辑发送到Executor端(分布式节点)执行
      为了区分不同的处理效果，所以将RDD的方法称之为算子
      RDD的方法外部的操作都是在Driver端执行的，而方法内部的逻辑代码是在Executor端执行。
     */
    def foreach(): Unit = {
      val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4),2)
      // foreach 其实是Executor端内存数据打印
      rdd.foreach(println)
      println("-----------------")
      // 其实是driver端内存集合的循环遍历方法
      rdd.collect().foreach(println)
    }



  }
}
