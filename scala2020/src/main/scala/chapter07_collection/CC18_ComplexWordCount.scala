package chapter07_collection

import scala.collection.mutable.ArrayOps

/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-27 11:19:00
  * Desc: 复杂的wordcout，并按照单词的数量进行倒序
  */
object CC18_ComplexWordCount {
  def main(args: Array[String]): Unit = {
    val list = List(
      ("hello",1),
      ("hello world",2),
      ("hello scala",2),
      ("hello spark",2),
      ("hello flink",2)
    )
    // 方法一：对list元祖中的元素直接相乘，然后进行扁平化，就变成正常的了
    val strings: List[String] = list.map(kv => ((kv._1+" ")*kv._2))
    println(strings) //List(hello , hello world hello world , hello scala hello scala , hello spark hello spark , hello flink hello flink hello flink )
    val result: List[(String, Int)] = strings.flatMap(_.split(" ")).
      groupBy(word => word)
      .map(kv => (kv._1, kv._2.length))
      .toList.sortBy(_._2)(Ordering[Int].reverse)
      .take(5)
    println(result) // List((hello,9), (world,2), (flink,2), (spark,2), (scala,2))

    // 方法二：先对列表元组中的元素切割然后匹配上出现的次数，最后分组统计求和
    val tuples: List[(String, Int)] = list.flatMap(
      tuple => {
        val strings = tuple._1.split(" ")
        strings.map(word => (word, tuple._2))
      }
    )
    println(tuples)
    // List((hello,1), (hello,2), (world,2), (hello,2), (scala,2), (hello,2), (spark,2), (hello,2), (flink,2))
   // 对元组按照单词进行分组
   val stringToTuples: Map[String, List[(String, Int)]] = tuples.groupBy(_._1)
    println(stringToTuples) // Map(world -> List((world,2)), flink -> List((flink,2)), spark -> List((spark,2)), scala -> List((scala,2)), hello -> List((hello,1), (hello,2), (hello,2), (hello,2), (hello,2)))
   // 叠加每个单词预统计的个数值
    val countMap: Map[String, Int] = stringToTuples.mapValues(
      tupleList => tupleList.map(_._2).sum
    )
    println(countMap) // Map(world -> 2, flink -> 2, spark -> 2, scala -> 2, hello -> 9)
    // 转换成list进行排序
    val re: List[(String, Int)] = countMap.toList.sortWith(_._2 > _._2).take(5)
    println(re) // List((hello,9), (world,2), (flink,2), (spark,2), (scala,2))
    // todo
  }
}
