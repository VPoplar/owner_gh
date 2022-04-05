package chapter07_collection

import scala.collection.mutable.ListBuffer
/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-17 17:17:00
  * Desc: 可变列表
  */
object CC05_ListBuffer {
  def main(args: Array[String]): Unit = {
    // 1 创建可变列表
    val list1: ListBuffer[Int]  = new ListBuffer[Int]()
    val list2: ListBuffer[Int] = ListBuffer(1,2,3,4)
    println(list1) // ListBuffer()
    println(list2) // ListBuffer(1, 2, 3, 4)
    // 2 添加元素
    list2.append(5)
    list2.prepend(0)
    println(list2) // ListBuffer(0, 1, 2, 3, 4, 5)
    list2.insert(6,6) // ListBuffer(0, 1, 2, 3, 4, 5, 6)
    println(list2)
    println("-------------------")
    -2 +=: -1 +=: list2 += 7 += 8
    println(list2) // ListBuffer(-2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8)
    // 3 合并list
    val list3 = ListBuffer("a","b","c")
    val list6 = ListBuffer(22,23,24)
    val list4: ListBuffer[Any] = list2 ++ list3
    println(list4) // ListBuffer(-2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, a, b, c)
    val list5: ListBuffer[Int] = list2 ++=: list6
    println(list5)  // ListBuffer(-2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 22, 23, 24)

    // 4 修改元素
    list2(0) = 111
    list2.update(8,888)
    println(list2)  // ListBuffer(111, -1, 0, 1, 2, 3, 4, 5, 888, 7, 8)
    // 5 移除元素
    list2.remove(2) // ListBuffer(111, -1, 1, 2, 3, 4, 5, 888, 7, 8)
    println(list2)
    list2 -= 111
    println(list2) // ListBuffer(-1, 1, 2, 3, 4, 5, 888, 7, 8)






  }
}
