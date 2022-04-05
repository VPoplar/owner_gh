package chapter07_collection

/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-14 22:33:00
  * Desc: 多维数组
  */
object CC03_MultiArray {
  def main(args: Array[String]): Unit = {
    // 1 创建二维数组
    val array: Array[Array[Int]] = Array.ofDim[Int](2,3)  // 二维数组，里面有两个数组，每个数组里面有三个值
    // 2 访问元素
    array(0)(0) = 1
    array(0)(1) = 2
    array(0)(2) = 3
    array(1)(0) = 10
    array(1)(1) = 11
    array(1)(2) = 12
    println(array.mkString(","))  // [I@32d992b2,[I@5dfcfece
    // 遍历数组
    for(i <- 0 until array.length; j <- 0 until array(i).length){
      println(array(i)(j))
    }
    for(i <- 0 until array.length; j <- 0 until array(i).length){
      print(array(i)(j)+" ")
      if(j == array(i).length-1) println()
    }
    for(i <- array.indices; j <- array(i).indices){
      print(array(i)(j)+" ")
      if(j == array(i).length-1) println()
    }
    // 用foreach来编写
    array.foreach(line => line.foreach(println))
    array.foreach(_.foreach(println))


  }
}
