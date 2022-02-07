package spark_streaming

import org.apache.kafka.clients.consumer.{ConsumerConfig, ConsumerRecord}
import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.dstream.{InputDStream, ReceiverInputDStream}
import org.apache.spark.streaming.kafka010.{ConsumerStrategies, KafkaUtils, LocationStrategies}
import org.apache.spark.streaming.receiver.Receiver
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.util.Random

object Streaming04_kafka {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境对象
    // StreamingContext创建时，需要传递两个参数
  // 第一个参数表示环境配置
  val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkStreaming")
  // 第二个参数表示批量处理的周期（采集周期）；默认是毫秒的
  val ssc: StreamingContext = new StreamingContext(conf,Seconds(2))
    // TODO 逻辑处理
    // 3.定义 Kafka 参数
      val kafakPara: Map[String, Object] = Map[String, Object](
        ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG -> "linux1:9092,linux2:9092,linux3:9092",
        ConsumerConfig.GROUP_ID_CONFIG -> "atguigu",
        "key.deserializer" -> "org.apache.kafka.common.serialization.StringDeserializer",
        "value.deserializer" -> "org.apache.kafka.common.serialization.StringDeserializer"
      )
    //4.读取 Kafka 数据创建 DStream;直连模式
    val kafkaDataDS: InputDStream[ConsumerRecord[String, String]] = KafkaUtils.createDirectStream[String, String](
      ssc,
      LocationStrategies.PreferConsistent,
      ConsumerStrategies.Subscribe[String, String](Set("atguiguNew"), kafakPara)
    )
    kafkaDataDS.map(_.value()).print()

    ssc.start()
    ssc.awaitTermination()
}

}
// 查看kafka消费进度
// bin/kafka-consumer-groups.sh --describe --bootstrap-server linux1:9092 --group atguigu