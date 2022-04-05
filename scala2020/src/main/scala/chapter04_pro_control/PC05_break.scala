package chapter04_pro_control

import scala.util.control.Breaks
import scala.util.control.Breaks._
/**
  * Author: LiuZheHui
  * CreateTime: 2022-02-25 09:19:00
  * Desc: 循环中断
  */
object
PC05_break {
  def main(args: Array[String]): Unit = {
    // 1 采用抛出异常的方式，退出循环
    try {
      for(i <- 1 to 5){
        if(i == 3)
          throw new RuntimeException
        println(i)
      }
    }catch {
      case e:Exception =>    // 这个代表什么都不做，只是退出循环
    }
    println("--------------")
    // 2 使用scala中的Breaks类的Break方法，实现异常的抛出和捕捉
    Breaks.breakable(
      for(i <- 1 to 5){
        if(i == 3)
          Breaks.break()
        println(i)
      }
    )
    println("--------------")
    breakable(
      for (i <- 0 until 5){
        if (i == 3)
          break()
        println(i)
      }
    )

    println("这是循环外的代码")


  }
}
