package spark_streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.{Seconds, StreamingContext, StreamingContextState}
// TODO 优雅的关闭：就是不直接杀死，而是等待当前的任务跑完再杀死
// 一般是通过第三方文件或者数据库的表来进行判断
object Streaming08_close {
  def main(args: Array[String]): Unit = {
    /*
    线程的关闭：
    val thread = new Thread()
    thread.start()
    thread.stop(); // 强制关闭
     */
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkStreaming")
    val ssc = new StreamingContext(sparkConf, Seconds(3))

    val lines = ssc.socketTextStream("localhost", 9999)
    val mapDS: DStream[(String, Int)] = lines.map((_,1))

    ssc.start()

    // 如果想要关闭采集器，那么需要创建新的线程
    // 而且需要在第三方程序中增加关闭状态
    new Thread(
      new Runnable {
        override def run(): Unit = {
          /* 优雅的关闭
           计算节点不再接收新的数据，而是将现有的数据处理完毕，然后再关闭
           Mysql : Table(stopSpark) => Row => data
           Redis : Data（K-V）
           ZK    : /stopSpark
          HDFS  : /stopSpark */
          /* 示例
          while (true) {
            if (true) {
              // 获取spark_streaming的状态
              val state: StreamingContextState = ssc.getState()
              if (state == StreamingContextState.ACTIVE){
                ssc.stop(true,true)  // 第二个参数就代表优雅的关闭
              }
            }
            Thread.sleep(5000)
          } */
          Thread.sleep(5000)
          val state: StreamingContextState = ssc.getState()
          if ( state == StreamingContextState.ACTIVE ) {
            ssc.stop(true, true)
          }
          System.exit(0)
        }
      }
    ).start()

    // block 阻塞main线程
    ssc.awaitTermination()


  }

}
