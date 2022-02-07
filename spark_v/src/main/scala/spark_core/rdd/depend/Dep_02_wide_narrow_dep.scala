package spark_core.rdd.depend

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Dep_02_wide_narrow_dep {
  def main(args: Array[String]): Unit = {
    //创建spark运行配置对象
    // TODO 查看依赖关系
    // OneToOneDependency -- 窄依赖
    // ShuffleDependency -- 宽依赖 （遇到一个宽依赖的算子就会划分一个分区）
    // JDBC : Connection
    val spark_conf = new SparkConf().setMaster("local").setAppName("worldcount")
    val sc = new SparkContext(spark_conf)
    // 执行业务操作
    // 读取文件，一行一行的读取
    //    hello world
    val lines: RDD[String] = sc.textFile("datas\\word.txt")
    println(lines.dependencies)  // 能够查看RDD的依赖关系
    // List(org.apache.spark.OneToOneDependency@4422dd48)  窄依赖
    println("------------------------------")
    // 将一行数据拆分，形成一个个的单词
    // "hello world" => hello, world, hello, world
    var worlds: RDD[String] = lines.flatMap(_.split(" "))
    println(worlds.dependencies)  // 能够查看RDD的依赖关系
    println("------------------------------")
    // hello => (hello, 1)
    // 将单词进行结构的转换，方便统计
    val worldone: RDD[(String, Int)] = worlds.map((_,1))
    println(worldone.dependencies)  // 能够查看RDD的依赖关系

    println("------------------------------")
    // 将转换后的数据进行分组聚合
    val worldToSum: RDD[(String, Int)] = worldone.reduceByKey(_+_)
    println(worldToSum.dependencies)  // 能够查看RDD的依赖关系
    // List(org.apache.spark.ShuffleDependency@55d58825)  宽依赖
    println("------------------------------")
    // 将数据打印出来
    val array: Array[(String, Int)] = worldToSum.collect()
    array.foreach(println)
    // TODO 关闭连接
    sc.stop()
  }
}
