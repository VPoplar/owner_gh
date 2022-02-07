package spark_core.rdd.builder

import org.apache.spark.{SparkConf, SparkContext}

object Spark01_RDD_File_Par_Demo {
  def main(args: Array[String]): Unit = {

    // TODO 准备环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc = new SparkContext(sparkConf)
    // TODO 数据
    /*
      数据(除最后一行外有回车换行)          偏移量
      1234567@@  >=  012345678
      89@@  >=  9101112
      0   >=  13
     */
    // TODO 数据分区的个数
    //  14bytes/2   =  7
    // 14/7  =  2  分区数量
    // TODO 数据位置在分区的分配
    //  [0, 7]   => 1234567
    //  [7, 14]  => 890

    // 1. 数据以行为单位进行读取
    //    spark读取文件，采用的是hadoop的方式读取，所以一行一行读取，和字节数没有关系
    // 2. 数据读取时以偏移量为单位,偏移量不会被重复读取

    val rdd = sc.textFile("datas/word.txt", 2)

    rdd.saveAsTextFile("output")


    // TODO 关闭环境
    sc.stop()
  }
}
