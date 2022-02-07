package spark_core.rdd.operator.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Action_00_base {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Action")
    val sc: SparkContext = new SparkContext(conf)
    // TODO 调用方法
    base()
    // TODO   具体执行逻辑
    def base(): Unit = {
      val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4))
      // TODO 行动算子：其实就是触发作业执行的方法
      // 底层调用的就是环境对象的runJob方法
      // 底层代码中会创建ActiveJob,并提交执行
      rdd.collect()
    }

    // TODO 关闭资源
    sc.stop()
  }
}
