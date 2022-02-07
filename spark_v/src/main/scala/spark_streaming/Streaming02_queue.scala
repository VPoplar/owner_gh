package spark_streaming

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.dstream.{DStream, InputDStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.mutable

object Streaming02_queue {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境对象
    // StreamingContext创建时，需要传递两个参数
    // 第一个参数表示环境配置
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkStreaming")
    // 第二个参数表示批量处理的周期（采集周期）；默认是毫秒的
    val ssc: StreamingContext = new StreamingContext(conf,Seconds(2))
    // TODO 逻辑处理
    // 创建RDD队列
    val rddQueue: mutable.Queue[RDD[Int]] = new mutable.Queue[RDD[Int]]()
    val inputStream: InputDStream[Int] = ssc.queueStream(rddQueue,oneAtATime = false)
    val mapStream: DStream[(Int, Int)] = inputStream.map((_,1))
    val reducedStream: DStream[(Int, Int)] = mapStream.reduceByKey(_+_)
    // 打印结果
    reducedStream.print()
    // 启动任务
    ssc.start()
    // 循环创建并向RDD队列中放入RDD
    for (i <- -1 to 5) {
      rddQueue += ssc.sparkContext.makeRDD(1 to 300,10)
      Thread.sleep(2000)
    }

    ssc.awaitTermination()

  }

}
