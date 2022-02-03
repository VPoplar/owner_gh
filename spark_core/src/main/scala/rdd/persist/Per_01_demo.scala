package rdd.persist

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Per_01_demo {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("persist")
    val sc = new SparkContext(conf)
    val rdd: RDD[String] = sc.makeRDD(List("hello spark","hello scala"))

    val fm_rdd: RDD[String] = rdd.flatMap(_.split(" "))

    val map_rdd: RDD[(String, Int)] = fm_rdd.map(
      word => {
        println("----------")
        (word,1)
      }
    )

    // 分组聚合
    val rbk_rdd: RDD[(String, Int)] = map_rdd.reduceByKey(_+_)
    rbk_rdd.collect().foreach(println)
    println("----------------------")
    // 只分组不聚合
    val gby_rdd: RDD[(String, Iterable[Int])] = map_rdd.groupByKey()
    // 其实这里是重新跑了一遍之前的RDD
    gby_rdd.collect().foreach(println)
    sc.stop()
  }

}
