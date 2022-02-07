package spark_streaming

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.dstream.{DStream, InputDStream, ReceiverInputDStream}
import org.apache.spark.streaming.receiver.Receiver
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.mutable
import scala.util.Random

object Streaming03_user_define {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境对象
    // StreamingContext创建时，需要传递两个参数
    // 第一个参数表示环境配置
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkStreaming")
    // 第二个参数表示批量处理的周期（采集周期）；默认是毫秒的
    val ssc: StreamingContext = new StreamingContext(conf,Seconds(2))
    // TODO 逻辑处理
    val messageDS: ReceiverInputDStream[String] = ssc.receiverStream(new MyReceiver())
    messageDS.print()
  }

  /*
  自定义数据采集器
  1 继承receiver，定义泛型，传递参数
  2 重写方法
   */
  class MyReceiver extends Receiver[String](StorageLevel.MEMORY_ONLY) {
    private var flg = true
    override def onStart(): Unit = {
      new Thread(new Runnable {
        override def run(): Unit = {
          while ( flg ) {
            val message = "采集的数据为：" + new Random().nextInt(10).toString
            store(message)
            Thread.sleep(500)
          }
        }
      }).start()
    }

    override def onStop(): Unit = {
      flg = false;
    }
  }
}
