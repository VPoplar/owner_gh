package chapter07_collection

/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-19 10:57:00
  * Desc:  集合通用操作
  */
object CC11_CommonOP {
  def main(args: Array[String]): Unit = {
    val list = List(1,2,3)
    val set = Set(4,5,6)
    // （ 1 ）获取集合长度
    println(list.length)  // 3
    println(set.size)  // 3
    // （ 2 ）获取集合大小
    println(list.size) // 3
    println(set.size) // 3
    // （ 3 ）循环遍历
    for(elem <- list)
      println(elem) // 1 \n 2 \n 3
    set.foreach(println) // 4 \n 5 \n 6
    // （ 4 ）迭代器
    for(elem <- list.iterator) println(elem) // 1 \n 2 \n 3
    // （ 5 ）生成字符串
    println(list.mkString("--")) // 1--2--3
    // （ 6 ）是否包含
    println(list.contains(1)) //  true
    println(set.contains(1)) //  false

  }
}
