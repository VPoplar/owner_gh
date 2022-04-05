package chapter07_collection

/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-17 17:17:00
  * Desc: 列表-是有序的
  */
object CC04_List {
  def main(args: Array[String]): Unit = {
    // 1 创建一个list
    val list1: List[Int] = List(1,2,3,4)
    println(list1) //  List(1,2,3,4)
    println(list1.mkString(","))  // 1,2,3,4
    list1.foreach(println) // 1\n2\n3\n4
    // 2 访问元素，按照数据结构List来说是没有索引，这里是为了方便查询，做了优化
    println(list1(0)) // 1
    // list1(0) = 1   error
    // 3 添加元素
    val list2: List[Int] = 10 +: list1 // 往前添加 10
    val list3: List[Int] = list1 :+ 10 // 往后添加 10
    println(list2) // List(10, 1, 2, 3, 4)
    println(list3) // List(1, 2, 3, 4, 10)
    println("-------------------------------")
    val list4: List[Int] = list1.::(10) // 往前添加 List(10, 1, 2, 3, 4)
    val list6: List[Int] = Nil.::(16) // 生成一个新的List List(16)
    val list5: List[Int] = 1 :: 2 :: 3 :: Nil  // 生成一个新的List List(1, 2, 3)
    println(list6)
    println(list4)
    println(list5)
    // 4 合并列表
    val newList: List[Any] = list4 :: list5
    println(newList) // 并不是list中元素的拼接 List(List(10, 1, 2, 3, 4), 1, 2, 3)
    val list7: List[Int] = list4 ::: list5
    val list8: List[Int] = list4 ++ list5
    println(list7) //  List(10, 1, 2, 3, 4, 1, 2, 3)
    println(list8) //  List(10, 1, 2, 3, 4, 1, 2, 3)









  }
}
