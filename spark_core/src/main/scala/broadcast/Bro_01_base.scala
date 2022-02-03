package broadcast

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable

// TODO 未使用广播变量
object Bro_01_base {
  def main(args: Array[String]): Unit = {

    val sparConf = new SparkConf().setMaster("local").setAppName("Acc")
    val sc = new SparkContext(sparConf)
    // TODO 需求就是join操作
    val rdd1 = sc.makeRDD(List(("a", 1),("b", 2),("c", 3)))
    // val rdd2 = sc.makeRDD(List(("a", 2),("b", 3),("c", 4)))
    // join会导致数据量几何增长，并且会影响shuffle性能，不推荐使用
    // val re: RDD[(String, (Int, Int))] = rdd1.join(rdd2)
    // re.collect().foreach(println)
    val map: mutable.Map[String, Int] = mutable.Map(("a", 4),("b", 5),("c", 6))
    rdd1.map{
      case (w,c) => {
        val l: Int = map.getOrElse(w,0)
        (w,(c,l))
      }
    }.collect().foreach(println)

    sc.stop()
  }

}
