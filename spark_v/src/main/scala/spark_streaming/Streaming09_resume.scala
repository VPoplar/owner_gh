package spark_streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.{Seconds, StreamingContext, StreamingContextState}

// TODO 优雅的关闭：恢复数据，从检查点开始

object Streaming09_resume {
  def main(args: Array[String]): Unit = {
    val ssc = StreamingContext.getActiveOrCreate("cp", ()=>{
      val sparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkStreaming")
      val ssc = new StreamingContext(sparkConf, Seconds(3))

      val lines = ssc.socketTextStream("localhost", 9999)
      val wordToOne = lines.map((_,1))

      wordToOne.print()

      ssc
    })

    ssc.checkpoint("cp")

    ssc.start()
    ssc.awaitTermination() // block 阻塞main线程
  }

}
