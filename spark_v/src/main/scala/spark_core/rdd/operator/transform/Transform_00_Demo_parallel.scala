package spark_core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

// 从服务器日志数据 apache.log 中获取用户请求 URL 资源路径
object Transform_00_Demo_parallel {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    // TODO 算子 - map

    // 1. rdd的计算一个分区内的数据是一个一个执行逻辑
    //    只有前面一个数据全部的逻辑执行完毕后，才会执行下一个数据。
    //    分区内数据的执行是有序的。
    // 2. 不同分区数据计算是无序的。
    val rdd = sc.makeRDD(List(1,2,3,4),2)

    val mapRDD = rdd.map(
      num => {
        println(">>>>>>>> " + num)
        num
      }
    )
    val mapRDD1 = mapRDD.map(
      num => {
        println("######" + num)
        num
      }
    )

    mapRDD1.collect()

    sc.stop()
  }
}
