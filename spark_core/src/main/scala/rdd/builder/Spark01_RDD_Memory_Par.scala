package rdd.builder

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark01_RDD_Memory_Par {
  def main(args: Array[String]): Unit = {

    //准备环境
      val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
      sparkConf.set("spark.default.parallelism", "3")
      val sc: SparkContext = new SparkContext(sparkConf)
    //创建RDD,从内存中创建，将内存中集合的数据作为处理的数据源
    // sc.makeRDD(seq)  底层调用的就是parallelize() 方便理解
    // 第二个参数可以不传递的，那么makeRDD方法会使用默认值 ： defaultParallelism（默认并行度）
    //     scheduler.conf.getInt("spark.default.parallelism", totalCores)
    //    spark在默认情况下，从配置对象中获取配置参数：spark.default.parallelism
    //    如果获取不到，那么使用totalCores属性，这个属性取值为当前运行环境的最大可用核数
      val rdd: RDD[Int] = sc.makeRDD(
        Seq[Int](1,2,3),2
      )
      rdd.saveAsTextFile("output")

    //关闭环境
      sc.stop()
  }

}
