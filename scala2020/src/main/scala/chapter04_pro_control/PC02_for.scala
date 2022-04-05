package chapter04_pro_control

import scala.collection.immutable

/**
  * Author: LiuZheHui
  * CreateTime: 2022-02-24 10:51:00
  * Desc: for循环-非常灵活和强大
  */
object PC02_for {
  def main(args: Array[String]): Unit = {
    // java中的遍历方法： for(i=0;i<=10;i++){System.out.println(i + ". hello world") }
    // 1 范围遍历
    for (i <- 1 to 3){
      println(i + "hello world")
    }
    // 2 不包含边界的范围遍历
    for(x <- Range(1,3)){
      println(x)
    }
    for(y <- 1 until 3){   // until底层调用的就是Range方法
      println(y)
    }
    // 集合遍历
    for(z <- Array(11,12,13)){
      println(z)
    }
    for(z <- List(11,12,13)){
      println(z)
    }
    for(z <- Set(11,12,13)){
      println(z)
    }
    // 3 循环守卫，类似于continue
    // 正常的写法，行数太多了
    for(i <- 1 to 3){
      if(i != 2){
        println(i)
      }
    }
    // 循环守卫的写法
    for(i <- 1 to 3 if i != 2){
      println(i)
    }
    // 4 循环步长 通过 by 来展示  注意：步长不能为0（会报错），
    // 如果步长为小数的话，则需要转换为Double（推荐用BigDecimial），不然会存在精度的问题
    for(i <- 1 to 5 by 2){
      println(i)  // 1 3 5
    }
    for(i <- 5 to 1 by -2){
      println(i)  // 5 3 1
    }
    for(i <- 1 to 3 reverse){
      println(i)  // 1 2 3
    }
    for(i <- 1.0 to 3.0 by 0.3){
      println(i)
    }
    println("-----------------------------")
    // 5 循环嵌套
    for(i <- 1 to 3){
      for(j <- 1 to 3){
        println("i="+i+" j="+j)
      }
    }
    println("--------------------------")
    for(i <- 1 to 3; j <- 1 to 3){
      println("i="+i+" j="+j)
    }
    // 6 循环引入变量
    println("---------------------")
    for(i <- 1 to 5 ;j=i-1){
      println("i="+i+" j="+j)
    }
    println("---------------------")
    for{ i <- 1 to 5
        j=i-1}
    {
      println("i="+i+" j="+j)
    }
    // 7 循环返回值：默认都是Unit
    val a:Unit = for(i <- 1 to 5){
      println(i)
    }
    println("a="+a)
    // yield 将遍历过程中处理的结果返回到一个新 Vector 集合中;开发中很少用
    val b: immutable.IndexedSeq[Int] = for(i <- 1 to 5) yield i
    println(b)  // Vector(1, 2, 3, 4, 5)
    // 倒序打印 reverse
    for(i <- 1 to 3 reverse){
      println(i)  // 3 2 1
    }





  }
}
