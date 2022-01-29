package rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}

// reduceByKey-要求分区内和分区间的聚合规则是一样的，比如按照key聚合
// 如果分区内和分区间的规则不一样，则无法使用比如分区内求最大值，分区间求和；这就需要用到aggregateByKey
object Transform_15_kv_reduceByKey {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    partitionBy()
    println("-----------------")
    //sortBy_test()
    // TODO 关闭资源
    sc.stop()

    // TODO partitionBy: 对数据按照指定的规则进行分区；区别于coalesce和repartition（只是对分区数量进行改变）
      def partitionBy(): Unit = {
        val rdd = sc.makeRDD(List(
          ("a", 1), ("a", 2), ("a", 3), ("b", 4)
        ))

        // reduceByKey : 相同的key的数据进行value数据的聚合操作
        // scala语言中一般的聚合操作都是两两聚合，spark基于scala开发的，所以它的聚合也是两两聚合
        // 【1，2，3】
        // 【3，3】
        // 【6】
        // reduceByKey中如果key的数据只有一个，是不会参与运算的。
        val reduceRDD: RDD[(String, Int)] = rdd.reduceByKey( (x:Int, y:Int) => {
          println(s"x = ${x}, y = ${y}")
          x + y
        } )

        reduceRDD.collect().foreach(println)

      }




  }
}
