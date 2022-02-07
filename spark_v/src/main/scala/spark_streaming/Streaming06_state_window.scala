package spark_streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

object Streaming06_state_window {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkStreaming")
    val ssc = new StreamingContext(sparkConf, Seconds(3))

    val lines = ssc.socketTextStream("localhost", 9999)
    val mapDS: DStream[(String, Int)] = lines.map((_,1))
    // window窗口
    //窗口的范围应该是采集周期的整数倍-可以理解为一次计算多长时间范围内的数据
    // 窗口可以滑动的，但是默认情况下，一个采集周期进行滑动,可以理解为多长时间计算一次数据
    //这样的话，可能会出现重复数据的计算，为了避免这种情况，可以改变滑动的滑动（步长）
    val windowDS: DStream[(String, Int)] = mapDS.window(Seconds(6),Seconds(6))
    val reDS: DStream[(String, Int)] = windowDS.reduceByKey(_+_)
    reDS.print()

    ssc.start()
    ssc.awaitTermination()
  }

}
