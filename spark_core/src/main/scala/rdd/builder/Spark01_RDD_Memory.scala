package rdd.builder

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark01_RDD_Memory {
  def main(args: Array[String]): Unit = {

    //准备环境
      val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
      val sc: SparkContext = new SparkContext(sparkConf)
    //创建RDD,从内存中创建，将内存中集合的数据作为处理的数据源
      val seq: Seq[Int] = Seq[Int](1,2,3,4)
    // sc.makeRDD(seq)  底层调用的就是parallelize() 方便理解
      val rdd: RDD[Int] = sc.parallelize(seq)
      rdd.collect().foreach(println)

    //关闭环境
      sc.stop()
  }

}
