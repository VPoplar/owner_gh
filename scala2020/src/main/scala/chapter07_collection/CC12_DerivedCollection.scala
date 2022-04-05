package chapter07_collection

/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-20 10:13:00
  * Desc: 衍生集合的常用操作
  */
object CC12_DerivedCollection {
  def main(args: Array[String]): Unit = {
    val list1 = List(1,2,3)
    val list2 = List(3,4,5,6)
    // （ 1 ）获取集合的头
    println(list1.head) // 1
    // （ 2 ）获取集合的尾（不是头的就是尾）
    println(list1.tail)  // List(2, 3)
    // （ 3 ）集合最后一个数据
    println(list1.last)  // 3
    // （ 4 ）集合初始数据（不包含最后一个）
    println(list1.init) // List(1, 2)
    // （ 5 ）反转
    println(list1.reverse) //  List(3,2,1)
    // （ 6 ）取前（后）n 个元素
    println(list1.take(2))  // List(1, 2)
    println(list1.takeRight(2))  //  List(2, 3)
    // （ 7 ）去掉前（后） n 个元素
    println(list1.drop(2)) // List(3)
    println(list1.dropRight(2)) // List(1)
    // （ 8 ）并集
    println(list1.union(list2)) // List(1, 2, 3, 3, 4, 5, 6)
    println(list2.union(list1)) // List(3, 4, 5, 6, 1, 2, 3)
    println(list1 ::: list2)  // List(1, 2, 3, 3, 4, 5, 6)
    // （ 9 ）交集
    println(list1.intersect(list2)) // List(3)
    // （ 10 ）差集
    println(list1.diff(list2)) // List(1, 2)
    println(list2.diff(list1)) //  List(4, 5, 6)
    // （ 11 ）拉链：形成一个映射关系，如果没有关联上则不进行关联
    println(list1.zip(list2)) // List((1,3), (2,4), (3,5))
    println(list2.zip(list1)) // List((3,1), (4,2), (5,3))
  }

}
