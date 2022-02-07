package spark_core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

// mapPartitions : 可以以分区为单位进行数据转换操作
//                 但是会将整个分区的数据加载到内存进行引用
//                 如果处理完的数据是不会被释放掉，存在对象的引用。
//                 在内存较小，数据量较大的场合下，容易出现内存溢出。
object Transform_02_mapPartitions {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)
    // TODO 创建数据
    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4),2)
    val map_rdd: RDD[Int] = rdd.mapPartitions(
      iter => {
        println(">>>>>>>>")
        iter.map(_ * 2)
      }
    )
    map_rdd.collect().foreach(println)

    sc.stop()
  }
}
