package spark_core.broadcast

import org.apache.spark.broadcast.Broadcast
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable

// TODO 使用广播变量
object Bro_02_base {
  def main(args: Array[String]): Unit = {

    val sparConf = new SparkConf().setMaster("local").setAppName("Acc")
    val sc = new SparkContext(sparConf)
    // TODO 需求就是join操作
    val rdd1 = sc.makeRDD(List(("a", 1),("b", 2),("c", 3)))
    val map: mutable.Map[String, Int] = mutable.Map(("a", 4),("b", 5),("c", 6))
    // 封装广播变量
    val bc: Broadcast[mutable.Map[String, Int]] = sc.broadcast(map)
    rdd1.map{
      case (w,c) => {
        // 方法广播变量
        val l: Int = bc.value.getOrElse(w,0)
        (w,(c,l))
      }
    }.collect().foreach(println)

    sc.stop()
  }

}
