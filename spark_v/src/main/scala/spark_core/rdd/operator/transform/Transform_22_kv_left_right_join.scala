package spark_core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Transform_22_kv_left_right_join {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    join()
    println("-----------------")
    // TODO 关闭资源
    sc.stop()

    // TODO left right join  相当于SQL中的左连接和右连接

    def join(): Unit = {
      val rdd1 = sc.makeRDD(List(("a", 1), ("b", 2), ("c", 3)))
      val rdd2 = sc.makeRDD(List(("b", 3), ("c", 2), ("d", 3), ("c", 4)))
      val left_rdd: RDD[(String, (Int, Option[Int]))] = rdd1.leftOuterJoin(rdd2)
      val right_rdd: RDD[(String, (Option[Int], Int))] = rdd1.rightOuterJoin(rdd2)
      left_rdd.collect().foreach(println)
      println("--------------")
      right_rdd.collect().foreach(println)
    }


  }
}
