package spark_core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

// glom 将同一个分区的数据直接转换为相同类型的内存数组进行处理，分区不变
object Transform_05_glom {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)
    glom()
    glomPrac()
    sc.stop()
    def glom(): Unit = {
      // TODO 创建数据
      val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4), 2)
      // List => Int
      // Int => Array
      val glom_rdd: RDD[Array[Int]] = rdd.glom()
      glom_rdd.collect().foreach(data => println(data.mkString(",")))
    }
    //TODO 计算所有分区最大值求和（分区内取最大值，分区间最大值求和）
    def glomPrac(): Unit = {
      // TODO 创建数据
      val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4), 2)
      // 【1，2】，【3，4】
      // 【2】，【4】
      // 【6】
      val glom_rdd: RDD[Array[Int]] = rdd.glom()
      val max_rdd = glom_rdd.map(
        array => {
          array.max
        }
      )
      println("---------------------------------------")
      println(max_rdd.collect().sum)
    }
  }
}
