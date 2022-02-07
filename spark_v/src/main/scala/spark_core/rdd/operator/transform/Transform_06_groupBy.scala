package spark_core.rdd.operator.transform

import java.text.SimpleDateFormat
import java.util.Date

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

// groupBy 分组
object Transform_06_groupBy {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)
    groupBy()
    println("-----------------")
    groupByString()
    println("-----------------")
    groupByPrc()
    sc.stop()
    // 1 对Int类型进行数据处理
    def groupBy(): Unit = {
      val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4), 2)
      def groupBy_logic(num :Int)={
        num % 2
      }
      val gb_rdd: RDD[(Int, Iterable[Int])] = rdd.groupBy(groupBy_logic)
      gb_rdd.collect().foreach(println)
    }
    // 2 对String类型进行数据处理：注意分区和分组没有必然的联系，一般都会产生shuffle
    def groupByString(): Unit = {
      val rdd: RDD[String] = sc.makeRDD(List("hello", "scala","hadoop", "spark"), 2)  // 2 代表分区
      val rdd_result: RDD[(Char, Iterable[String])] = rdd.groupBy(_.charAt(0))
      rdd_result.collect().foreach(println)
    }
    // 3 练习：从服务器日志数据 apache.log 中获取每个时间段访问量
    def groupByPrc(): Unit = {
      val rdd: RDD[String] = sc.textFile("datas\\apache.log")
      val time_rdd: RDD[(String, Iterable[(String, Int)])] = rdd.map(
        line => {
          val data: Array[String] = line.split(" ")
          val time: String = data(3)
          // time.substring(0,1)
          val sdf = new SimpleDateFormat("dd/MM/yyyy:HH:mm:ss")
          val date: Date = sdf.parse(time)
          val sdf_hour = new SimpleDateFormat("HH")
          val hour: String = sdf_hour.format(date)
          (hour, 1)
        }
      ).groupBy(_._1)
      time_rdd.map{
        case (hour, iter) => {
          (hour, iter.size)
        }}.collect().foreach(println)
      }}

}
