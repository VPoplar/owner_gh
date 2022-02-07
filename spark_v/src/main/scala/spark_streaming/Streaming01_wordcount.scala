package spark_streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object Streaming01_wordcount {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境对象
    // StreamingContext创建时，需要传递两个参数
    // 第一个参数表示环境配置
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkStreaming")
    // 第二个参数表示批量处理的周期（采集周期）；默认是毫秒的
    val ssc: StreamingContext = new StreamingContext(conf,Seconds(2))
    // TODO 逻辑处理
    // 获取netcat端口数据
    val lines: ReceiverInputDStream[String] = ssc.socketTextStream("localhost",9999)
    val words: DStream[String] = lines.flatMap(_.split(" "))
    val word_count: DStream[(String, Int)] = words.map((_,1)).reduceByKey(_+_)
    word_count.print()

    // 由于spark_streaming采集器是长期执行的任务，所以不能直接关闭
    // 如果main方法执行完毕，应用程序也会自动结束，所以不能让main方法执行完毕
    // ssc.stop()
    // 1 启动采集器
    ssc.start()
    // 2 等待采集器的关闭
    ssc.awaitTermination()

    // 进入nc.exe的cmd目录下，然后执行  nc -lp 9999   就可以输入数据了
    // 端口监控  nc localhost 9999
  }

}
