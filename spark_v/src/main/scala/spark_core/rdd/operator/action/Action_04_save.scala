package spark_core.rdd.operator.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Action_04_save {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Action")
    val sc: SparkContext = new SparkContext(conf)
    // TODO 调用方法
    saveAsTextFile()
    saveAsObjectFile()
    saveAsSequenceFile()
    // TODO 关闭资源
    sc.stop()
    // TODO 11 saveAsTextFile  保持为文本-常用
    def saveAsTextFile(): Unit = {
      val rdd: RDD[(String, Int)] = sc.makeRDD(List(("a",1),("a",1),("b",1),("c",1)),2)
      rdd.saveAsTextFile("output1")
    }
    // TODO 12 saveAsObjectFile 算子-保存为对象
    // 方法要求数据的格式必须为K-V类型
    def saveAsObjectFile(): Unit = {
      // val spark_core.rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4))
      val rdd: RDD[(String, Int)] = sc.makeRDD(List(("a",1),("a",1),("b",1),("c",1)),2)
      rdd.saveAsObjectFile("output2")
    }
    // TODO 13 saveAsSequenceFile 算子-保存为序列化的文件
    def saveAsSequenceFile(): Unit = {
      // val spark_core.rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4))
      val rdd: RDD[(String, Int)] = sc.makeRDD(List(("a",1),("a",1),("b",1),("c",1)),2)
      rdd.saveAsSequenceFile("output3")
    }


  }
}
