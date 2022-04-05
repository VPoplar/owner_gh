package chapter07_collection

/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-17 20:25:00
  * Desc: 不可变集合Set，无序，不重复
  */
object CC06_Set {
  def main(args: Array[String]): Unit = {
    // 1 创建set
    val set1: Set[Int] = Set(1,2,3,3,4)
    println(set1) // Set(1, 2, 3, 4)
    // 2 添加元素
    val set3: Set[Int] = set1 + 5
    println(set3) // Set(5, 1, 2, 3, 4) 注意是无序添加的
    //3 删除元素
    val set4: Set[Int] = set3 - 5
    println(set4) // Set(1, 2, 3, 4)
    // 4 合并集合
    val set5 = Set(3,4,5,6,7)
    val set6: Set[Int] = set4 ++ set5
    println(set6) // Set(5, 1, 6, 2, 7, 3, 4)





  }
}
