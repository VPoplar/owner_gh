package chapter07_collection

import scala.collection.mutable

/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-18 19:37:00
  * Desc: 元组，最多有22个元素
  */
object CC10_Tuple {
  def main(args: Array[String]): Unit = {
    // 1 创建元祖
    val tuple: (String, String, Int, Int) = ("a","b",1,2)
    println(tuple)
    // 2 访问数据
    println(tuple._1) // a
    println(tuple._2) // b
    println(tuple.productElement(2))  // 1  这个是代表索引
    // 3 遍历元组元素
    for (elem <- tuple.productIterator){
      println(elem) // a \n b \n 1 \n 2
    }
    // 4 嵌套元组
    val tuple1: (String, String, (Int, Int), Int) = ("a","b",(1,3),4)
    println(tuple1._3._2) // 3










    // todo
  }

}
