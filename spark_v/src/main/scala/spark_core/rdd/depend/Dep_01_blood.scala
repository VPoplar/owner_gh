package spark_core.rdd.depend

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD


object Dep_01_blood {
  def main(args: Array[String]): Unit = {
    //创建spark运行配置对象
    // TODO 查看血缘关系
    // JDBC : Connection
    val spark_conf = new SparkConf().setMaster("local").setAppName("worldcount")
    val sc = new SparkContext(spark_conf)
    // 执行业务操作
    // 读取文件，一行一行的读取
    //    hello world
    val lines: RDD[String] = sc.textFile("datas\\word.txt")
    println(lines.toDebugString)  // 能够查看血缘关系
    //(1) datas\word.txt MapPartitionsRDD[1] at textFile at Dep_01.scala:17 []
    //  datas\word.txt HadoopRDD[0] at textFile at Dep_01.scala:17 []
    println("------------------------------")
    // 将一行数据拆分，形成一个个的单词
    // "hello world" => hello, world, hello, world
    var worlds: RDD[String] = lines.flatMap(_.split(" "))
    println(worlds.toDebugString)  // 能够查看血缘关系
    println("------------------------------")
    // hello => (hello, 1)
    // 将单词进行结构的转换，方便统计
    val worldone: RDD[(String, Int)] = worlds.map((_,1))
    println(worldone.toDebugString)  // 能够查看血缘关系
    //(1) MapPartitionsRDD[3] at map at Dep_01.scala:27 []
    //|  MapPartitionsRDD[2] at flatMap at Dep_01.scala:22 []
    //|  datas\word.txt MapPartitionsRDD[1] at textFile at Dep_01.scala:17 []
    //|  datas\word.txt HadoopRDD[0] at textFile at Dep_01.scala:17 []
    println("------------------------------")
    // 将转换后的数据进行分组聚合
    val worldToSum: RDD[(String, Int)] = worldone.reduceByKey(_+_)
    println(worldToSum.toDebugString)  // 能够查看血缘关系
    //(1) ShuffledRDD[4] at reduceByKey at Dep_01.scala:31 []
    //+-(1) MapPartitionsRDD[3] at map at Dep_01.scala:27 []
    //|  MapPartitionsRDD[2] at flatMap at Dep_01.scala:22 []
    //|  datas\word.txt MapPartitionsRDD[1] at textFile at Dep_01.scala:17 []
    //|  datas\word.txt HadoopRDD[0] at textFile at Dep_01.scala:17 []
    println("------------------------------")
    // 将数据打印出来
    val array: Array[(String, Int)] = worldToSum.collect()
    array.foreach(println)
    // TODO 关闭连接
    sc.stop()
  }
}
