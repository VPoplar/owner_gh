package spark_core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

// coalesce : 缩减分区：默认不会重组,不会shuffle;用于大数据集过滤后，提高小数据集的执行效率
// 注意这里的coalesce不同于hive的coalesce
object Transform_10_coalesce {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    coalesce()
    println("-----------------")
    // TODO 关闭资源
    sc.stop()

    // TODO 执行逻辑
    def coalesce(): Unit = {
      val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4,5,6),2)
      val rdd_result: RDD[Int] = rdd.coalesce(3,true)
      rdd_result.saveAsTextFile("output")
    }




  }
}
