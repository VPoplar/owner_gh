package spark_core.rdd.persist

import org.apache.spark.rdd.RDD
import org.apache.spark.storage.StorageLevel
import org.apache.spark.{SparkConf, SparkContext}

object Per_02_cache_persist {
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
    // 备注:持久化操作必须在行动行动算子执行时完成
    // 持久化操作,只能将数据保存到内存中，如果想要保存到磁盘中，需要更改存储级别
    // map_rdd.cache()   底层调用的就是 persist(StorageLevel.MEMORY_ONLY)
    // 改为文件存储（磁盘存储）  保存为临时文件，作业运行完会删除的，但是checkpoint不会
    map_rdd.persist(StorageLevel.DISK_ONLY)
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
