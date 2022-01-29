package rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

// sample 样品(抽取)：根据指定的规则从数据集中抽取数据
object Transform_08_sample {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    sample()
    println("-----------------")
    // TODO 关闭资源
    sc.stop()
    // sample算子需要传递三个参数：
    //  withReplacement:表示抽取的数据是否放回,true(放回)，false（丢弃）
    //  fraction:如果抽取不放回的场合：数据源中每条数据被抽取的概率，基准值的概念
    //           如果抽取放回的场合：表示数据源中的每条数据被抽取的可能次数
    //  seed: 抽取数据时随机算法的种子; 如果不传递第三个参数，那么使用的是当前系统时间
    def sample(): Unit = {
      val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4,5,6,7,8,9,10))
      println(rdd.sample(
        false,
        0.6,
        1
      ).collect().mkString(","))

    }




  }
}
