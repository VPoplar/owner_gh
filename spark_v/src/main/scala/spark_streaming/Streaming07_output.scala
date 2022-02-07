package spark_streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

object Streaming07_output {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkStreaming")
    val ssc = new StreamingContext(sparkConf, Seconds(3))

    val lines = ssc.socketTextStream("localhost", 9999)
    val mapDS: DStream[(String, Int)] = lines.map((_,1))
    // reduceByKeyAndWindow  用于增加和删除数据(重复)
    // 当窗口范围比较大，但是滑动幅度比较小，那么可以采用增加数据和删除数据的方式
    // 减少计算重复的数据量，提升性能。
    val reDS: DStream[(String, Int)] = mapDS.reduceByKeyAndWindow(
      (x: Int, y: Int) => x + y,
      (x: Int, y: Int) => x - y,
      Seconds(9), Seconds(3)
    )
    //SparkStreaming如何没有输出操作，那么会提示错误
   // reDS.print()


    // 其他的输出方法
    //saveAsHadoopFiles
    //foreachRDD
    //saveAsTextFiles
    //saveAsObjectFiles
    ssc.start()

    ssc.awaitTermination()
  }

}
