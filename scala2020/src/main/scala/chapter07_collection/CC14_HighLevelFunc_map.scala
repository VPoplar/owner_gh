package chapter07_collection

/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-20 11:38:00
  * Desc: 高级函数 group ,filter,map,flatMap等等
  */
object CC14_HighLevelFunc_map {
  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,4,5)
    // 1 过滤
    // 选取偶数
    val newList = list.filter((elem:Int) => {elem%2 == 0})
    println(newList) // List(2, 4)
    // 选取奇数
    val newList2 = list.filter(_ % 2 == 1)
    println(newList2)
    // 2 映射map:把集合中每个数乘以2
    val list2 = list.map(_*2)
    println(list2) // List(2, 4, 6, 8, 10)
    // 4. 扁平映射
    // 将一组字符串进行分词，并保存成单词的列表
    val strings: List[String] = List("hello world", "hello scala", "hello java", "we study")
    val splitList: List[Array[String]] = strings.map( _.split(" ") )    // 分词
    val flattenList = splitList.flatten    // 打散扁平化

    println(flattenList) // List(hello, world, hello, scala, hello, java, we, study)

    val flatmapList = strings.flatMap(_.split(" "))
    println(flatmapList) // List(hello, world, hello, scala, hello, java, we, study)

    println("========================")

    // 5. 分组groupBy
    // 分成奇偶两组
    val groupMap: Map[Int, List[Int]] = list.groupBy( _ % 2)
    val groupMap2: Map[String, List[Int]] = list.groupBy( data => if (data % 2 == 0) "偶数" else "奇数")

    println(groupMap) // Map(1 -> List(1, 3, 5), 0 -> List(2, 4))
    println(groupMap2) // Map(奇数 -> List(1, 3, 5), 偶数 -> List(2, 4))

    // 给定一组词汇，按照单词的首字母进行分组
    val wordList = List("china", "america", "alice", "canada", "cary", "bob", "japan")
    println( wordList.groupBy( _.charAt(0) ) ) // Map(b -> List(bob), j -> List(japan), a -> List(america, alice), c -> List(china, canada, cary))









    //todo
  }

}
