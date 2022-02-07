package spark_core.wc

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object worldcount {
  def main(args: Array[String]): Unit = {
        //创建spark运行配置对象
    // TODO 建立和Spark框架的连接
    // JDBC : Connection
    val spark_conf = new SparkConf().setMaster("local").setAppName("worldcount")
    val sc = new SparkContext(spark_conf)
    // 执行业务操作
    // 读取文件，一行一行的读取
    //    hello world
    val lines: RDD[String] = sc.textFile("datas")
    // 将一行数据拆分，形成一个个的单词
    // "hello world" => hello, world, hello, world
    var worlds: RDD[String] = lines.flatMap(_.split(" "))
    // hello => (hello, 1)
    // 将单词进行结构的转换，方便统计
    val worldone: RDD[(String, Int)] = worlds.map((_,1))
    // 将转换后的数据进行分组聚合
    val worldToSum: RDD[(String, Int)] = worldone.reduceByKey(_+_)
    // 将数据打印出来
    val array: Array[(String, Int)] = worldToSum.collect()
    array.foreach(println)
    // TODO 关闭连接
    sc.stop()
  }
}
