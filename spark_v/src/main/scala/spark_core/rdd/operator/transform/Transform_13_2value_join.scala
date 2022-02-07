package spark_core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

// 双value类型：就是join操作
// 交集，并集和差集要求两个数据源数据类型保持一致
// 拉链操作两个数据源的类型可以不一致;但是连个数据源的分区数量和分区内中的元素需要保持一致
object Transform_13_2value_join {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    join()
    println("-----------------")
    //sortBy_test()
    // TODO 关闭资源
    sc.stop()

    // TODO 执行逻辑:包含了交集，差集合拉链的操作
      def join(): Unit = {
        val rdd1: RDD[Int] = sc.makeRDD(List(1,2,3,4))
        val rdd2: RDD[Int] = sc.makeRDD(List(3,4,5,6))
        val rdd3: RDD[String] = sc.makeRDD(List("3","4","5","6"))
        // intersection 交集
        val inner_rdd: RDD[Int] = rdd1.intersection(rdd2)
        println(inner_rdd.collect().mkString(","))
        // union 并集
        val union_rdd: RDD[Int] = rdd1.union(rdd2)
        println(union_rdd.collect().mkString(","))

        // subtract 差集
        val subtract_rdd: RDD[Int] = rdd1.subtract(rdd2)
        println(subtract_rdd.collect().mkString(","))
        // 拉链
        val zip_rdd: RDD[(Int, String)] = rdd1.zip(rdd3)
        println(zip_rdd.collect().mkString(","))
      }




  }
}
