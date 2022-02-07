package spark_core.rdd.builder

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark01_RDD_File {
  def main(args: Array[String]): Unit = {

    //准备环境
      val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
      val sc: SparkContext = new SparkContext(sparkConf)
    //创建RDD,从文件中创建
    //path路径默认以当前环境得根路径为基准，可以写绝对路径也可以写相对路径
    //D:\repo\idea_repo\guiguclasses\datas\1.txt
    //val spark_core.rdd: RDD[String] = sc.textFile("datas")  也可以读取整个目录下得文件
    //val spark_core.rdd: RDD[String] = sc.textFile("datas/1*.txt")  也可以使用通配符
    //val spark_core.rdd = sc.textFile("hdfs://linux1:8020/test.txt")  也可以是分布式存储系统路径：HDFS
    val rdd: RDD[String] = sc.textFile("datas/1*.txt")
    // val spark_core.rdd: RDD[(String, String)] = sc.wholeTextFiles("datas")
    // 读取的结果表示为元组，第一个元素表示文件路径，第二个元素表示文件内容
    // 特殊得方法，能够显示文件得路径 结果 file:/D:/repo/idea_repo/guiguclasses/datas/2.txt,hello spark)
      rdd.collect().foreach(println)

    //关闭环境
      sc.stop()
  }

}
