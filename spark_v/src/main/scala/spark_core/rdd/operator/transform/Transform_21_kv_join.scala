package spark_core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Transform_21_kv_join {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    join()
    println("-----------------")
    // TODO 关闭资源
    sc.stop()

    // TODO join  相当于SQL中的内连接
    /*
    两个不同数据源的数据，相同的key的value会连接在一起，形成元组
    如果两个数据源中key没有匹配上，那么数据不会出现在结果中
    如果两个数据源中key有多个相同的，会依次匹配，可能会出现笛卡尔乘积，数据量会几何性增长，会导致性能降低。
     */
    def join(): Unit = {
      val rdd1 = sc.makeRDD(List(("a", 1), ("b", 2), ("c", 3)))
      val rdd2 = sc.makeRDD(List(("b", 3), ("c", 2), ("d", 3), ("c", 4)))
      val join_rdd: RDD[(String, (Int, Int))] = rdd1.join(rdd2)
      join_rdd.collect().foreach(println)
    }


  }
}
