package chapter07_collection

/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-20 11:17:00
  * Desc: 简单计算函数
  */
object CC13_SimpleFunction {
  def main(args: Array[String]): Unit = {
    val list1 = List(1,3,2)
    val list2 = List(("a",4),("b",6),("c",5))
    // （ 1 ）求和
    var sum = 0
    for(elem <- list1){
      sum += elem
    }
    println(sum)  // 6
    println(list1.sum) // 6
    // （ 2 ）求乘积
    println(list1.product) // 6
    // （ 3 ）最大值
    println(list1.max) // 3
    println(list2.max) // (c,5)
    println(list2.maxBy((tuple:(String,Int))=>tuple._2))  // (b,6)
    println(list2.maxBy(_._2)) // (b,6)
    // （ 4 ）最小值
    println(list1.min) // 1
    println(list2.min) // (a,4)
    println(list2.minBy(_._2)) // (a,4)
    // （ 5 ）排序 sorted,sortBy,sortWith  默认都是升序
    // sorted
    val sorted: List[Int] = list1.sorted
    println(sorted) // List(1, 2, 3)
    println(sorted.reverse)  // 降序 List(3, 2, 1)
    // 传入隐式参数
    println(list1.sorted(Ordering[Int].reverse))  // 降序 List(3, 2, 1)
    // sortBy
    println(list2.sortBy(_._2)) // List((a,4), (c,5), (b,6))
    println(list2.sortBy(_._2).reverse) // List((b,6), (c,5), (a,4))
    // sortWith 可以自己定义排序的逻辑
    println(list1.sortWith( (a:Int,b:Int)=>{a < b } )) // List(1, 2, 3)
    println(list1.sortWith( _ < _)) // List(1, 2, 3)
    println(list1.sortWith( _ > _)) // List(3, 2, 1)
  }
}
