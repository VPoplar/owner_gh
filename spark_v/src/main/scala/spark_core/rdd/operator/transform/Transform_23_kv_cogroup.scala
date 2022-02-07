package spark_core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Transform_23_kv_cogroup {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    cogroup()
    println("-----------------")
    // TODO 关闭资源
    sc.stop()

    // TODO cogroup  connect+group 分组连接  相当于全连接

    def cogroup(): Unit = {
      val rdd1 = sc.makeRDD(List(("a", 1), ("b", 2), ("c", 3)))
      val rdd2 = sc.makeRDD(List(("b", 3), ("c", 2), ("d", 3), ("c", 4)))
      //val rdd3 = sc.makeRDD(List(("a", 1), ("b", 2), ("c", 3)))
      //val cogroup_rdd  = rdd1.cogroup(rdd2,rdd3)
      val cogroup_rdd: RDD[(String, (Iterable[Int], Iterable[Int]))] = rdd1.cogroup(rdd2)
      cogroup_rdd.collect().foreach(println)
    }


  }
}
