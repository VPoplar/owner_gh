package chapter02_datatype

import scala.io.StdIn
/**
  * Author: LiuZheHui
  * CreateTime: 2022-02-20 09:21:00
  * Desc: 控制台输入
  */
object DT05_stdIn {

  def main(args: Array[String]): Unit = {
    // 输入信息
    println("请输入您的大名：")
    val name: String = StdIn.readLine()
    println("请输入您的年龄:")
    val age: Int = StdIn.readInt()
    // 控制台打印输出
    println(s"欢迎${age}岁的${name}来到这里学习")
  }

}
