package spark_core.rdd.persist

import org.apache.spark.rdd.RDD
import org.apache.spark.storage.StorageLevel
import org.apache.spark.{SparkConf, SparkContext}

object Per_03_checkpoint {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("persist")
    val sc = new SparkContext(conf)
    // TODO 设置checkpoint的存储路径
    sc.setCheckpointDir("datas\\ck")
    val rdd: RDD[String] = sc.makeRDD(List("hello spark","hello scala"))

    val fm_rdd: RDD[String] = rdd.flatMap(_.split(" "))

    val map_rdd: RDD[(String, Int)] = fm_rdd.map(
      word => {
        println("----------")
        (word,1)
      }
    )
    /*
    cache:将数据临时存储在内存中供数据重用
    persist：更多的是将数据存储在磁盘文件中供数据重用；
          会涉及到磁盘IO，性能较低，但是数据安全；作业执行完毕，数据也会被清除
    checkpoint:将数据长久的保存在磁盘文件中，供数据重用，不会因为作业执行完毕被清除
          会涉及到磁盘IO，性能较低，但是数据安全
          为了保证数据安全，所以一般情况下，会独立执行作业
          为了能够提高效率，一般情况下，需要和cache联合使用
     */
    // checkpoint 需要落盘，需要指定检查点保存路径
    // 检查点路径保存的文件，当作业执行完毕后，不会被删除
    //
    map_rdd.cache()
    // map_rdd.checkpoint()
    // 分组聚合
    val rbk_rdd: RDD[(String, Int)] = map_rdd.reduceByKey(_+_)
    rbk_rdd.collect().foreach(println)
    println(rbk_rdd.toDebugString)
    println("----------------------")
    // 只分组不聚合
    val gby_rdd: RDD[(String, Iterable[Int])] = map_rdd.groupByKey()
    // 其实这里是重新跑了一遍之前的RDD
    println(gby_rdd.toDebugString)
    gby_rdd.collect().foreach(println)
    sc.stop()
  }

}
