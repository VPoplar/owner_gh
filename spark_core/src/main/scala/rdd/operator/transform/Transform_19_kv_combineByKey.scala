package rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Transform_19_kv_combineByKey {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    combineByKey()
    println("-----------------")
    // TODO 关闭资源
    sc.stop()

    // TODO combineByKey: aggregateByKey的延伸,需要传入三个参数
    // 第一个参数：将相同key的第一个数据进行结构转换，实现操作
    // 第一个参数：分区内的计算规则
    // 第一个参数：分区间的计算规则
      def combineByKey(): Unit = {
        val rdd = sc.makeRDD(List(
          ("a", 1), ("a", 2), ("b", 3),
          ("b", 4), ("b", 5), ("a", 6)
        ),2)

        val combine_rdd: RDD[(String, (Int, Int))] = rdd.combineByKey(
          v => (v,1),
          (t:(Int,Int), v) => {
            (t._1 + v, t._2 + 1)
          },
          (t1:(Int,Int), t2:(Int,Int)) => {
            (t1._1 + t2._1, t1._2 + t2._2)
          }
        )
        // mapValues区别于map,只对value进行操作
        val rdd_res: RDD[(String, Int)] = combine_rdd.mapValues {
          case (num, cnt) =>
            num / cnt
        }
        rdd_res.collect().foreach(println)
      }

  }
}
