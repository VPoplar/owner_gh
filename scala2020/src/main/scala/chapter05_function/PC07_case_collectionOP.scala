package chapter05_function

/**
  * Author: LiuZheHui
  * CreateTime: 2022-02-27 14:16:00
  * Desc: 集合操作
  */
object PC07_case_collectionOP {
  def main(args: Array[String]): Unit = {
    val arr:Array[Int] = Array(1,2,3,4)
    // 对数组进行处理，将处理的操作给抽象出来，并返回一个新的数组
    def arrayOperation(arr:Array[Int],op:Int=>Int):Array[Int] = {
      for(elem <- arr) yield op(elem)
    }
    //定义一个加一的操作
    def addOne(elem:Int):Int = {
      elem + 1
    }

    // 调用函数
    val ints: Array[Int] = arrayOperation(arr,addOne)
    println(ints.mkString(","))  // 2,3,4,5
  }

  // 也可以通过匿名函数来进行实现
  // 传入匿名函数，实现元素翻倍
  // val newArray2 = arrayOperation(arr, _ * 2)
  // println(newArray2.mkString(", "))

}
