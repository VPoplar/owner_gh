package spark_core.rdd.partitioner

import org.apache.spark.rdd.RDD
import org.apache.spark.{Partitioner, SparkConf, SparkContext}

object Par_01_customer {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("persist")
    val sc = new SparkContext(conf)
    // TODO 自定义分区-按照指定的规则将数据进行分区
    val rdd: RDD[(String, String)] = sc.makeRDD(List(
      ("a", "1"),
      ("b", "2"),
      ("c", "3")))
    val par_rdd: RDD[(String, String)] = rdd.partitionBy(new MyPartitioner)
    par_rdd.saveAsTextFile("datas\\par")

    sc.stop()
  }
  // TODO 自定义分区的类
  // 继承 Partitioner;重写方法
   class MyPartitioner extends Partitioner {
    def numPartitions: Int = 3
    def getPartition(key: Any): Int ={
      key match {
        case "a" => 0
        case "b" => 1
        case _ => 2
      }

    }}

}
