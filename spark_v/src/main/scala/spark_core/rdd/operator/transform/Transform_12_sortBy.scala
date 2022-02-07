package spark_core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

// sortBy : 排序
object Transform_12_sortBy {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    sortBy()
    println("-----------------")
    sortBy_test()
    // TODO 关闭资源
    sc.stop()

    // TODO 执行逻辑
    def sortBy(): Unit = {
      val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4,5,6),2)
      val rdd_result: RDD[Int] = rdd.sortBy(num => num,false)
      rdd_result.collect().foreach(println)
    }
    def sortBy_test(): Unit = {
      val rdd: RDD[(String, Int)] = sc.makeRDD(List(("1",2),("11",3),("2",4)),2)
      val rdd_re: RDD[(String, Int)] = rdd.sortBy(t => t._1.toInt)
      rdd_re.collect().foreach(println)
    }




  }
}
