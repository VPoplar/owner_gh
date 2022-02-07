package spark_streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

object Streaming06_state_join {
  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkStreaming")
    val ssc = new StreamingContext(sparkConf, Seconds(5))

    val lines1 = ssc.socketTextStream("localhost", 9999)
    val lines2 = ssc.socketTextStream("localhost", 8888)

    val datas1: DStream[(String, Int)] = lines1.map((_,8))
    val datas2: DStream[(String, Int)] = lines2.map((_,9))
    // 所谓的DStream的Join操作，其实就是两个RDD的join
    val joinDS: DStream[(String, (Int, Int))] = datas1.join(datas2)
    joinDS.print()

    ssc.start()
    ssc.awaitTermination()
  }

}
