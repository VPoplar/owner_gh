package chapter07_collection

/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-27 11:19:00
  * Desc: 正常的wordcout，并按照单词的数量进行倒序
  */
object CC17_CommonWordCount {
  def main(args: Array[String]): Unit = {
    val list = List(
            "hello",
            "hello world",
            "hello scala",
            "hello spark from scala",
            "hello flink from scala"
    )
    // 1 对字符串进行切分打散
    val fm_list: List[String] = list.flatMap(_.split(" "))
    println(fm_list) // List(hello, hello, world, hello, scala, hello, spark, from, scala, hello, flink, from, scala)
    // 2 对相同的单词进行分组
    val gk_list: Map[String, List[String]] = fm_list.groupBy(word => word)
    // 3 进行单词次数统计
    val countMap: Map[String, Int] = gk_list.map(kv => (kv._1,kv._2.length))
    println(countMap) // Map(world -> 1, flink -> 1, spark -> 1, scala -> 3, from -> 2, hello -> 5)
    // 4 对单词进行倒序排序
    val resultList: List[(String, Int)] = countMap.toList.sortWith(_._2 > _._2)
    println(resultList) // List((hello,5), (scala,3), (from,2), (world,1), (flink,1), (spark,1))
    resultList.foreach(println)


    // todo
  }
}
