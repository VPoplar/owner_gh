package chapter04_pro_control

import scala.io.StdIn

/**
  * Author: LiuZheHui
  * CreateTime: 2022-02-24 10:13:00
  * Desc: ifelse
  */
object PC01_ifelse {
  def main(args: Array[String]): Unit = {
    println("请输入您的年龄：")
    val age = StdIn.readInt()

    // 1 单分支
    if (age >= 18) {
      println("成年")
    }
    // 2 双分支
    if (age < 18) {
      println("未成年")
    } else {
      println("成年")
    }
    // 3 多分支
    if (age <= 6) {
      println("童年")
    } else if (age < 18) {
      println("青少年")
    } else if (age < 35) {
      println("青年")
    } else if (age < 60) {
      println("中年")
    } else {
      println("老年")
    }
    println("----------------------------")
    // 4 分支语句的返回值
    val result: Any = if (age <= 6) {
      println("童年")
      "童年"
    } else if (age < 18) {
      println("青少年")
      "青少年"
    } else if (age < 35) {
      println("青年")
      "青年"
    } else if (age < 60) {
      println("中年")
      "中年"
    } else {
      println("老年")
      "老年"
    }

    println("result= ", result)
    // 5 java中的三元运算符  String res = (age >= 18)?"成年":"未成年"
    val res: String = if (age >= 18) {
      "成年"
    } else {
      "未成年"
    }
    val res2: String = if (age >= 18) "成年" else "未成年"
    println(res, res2)

    // 6 嵌套查询
    if (age >= 18) {
      println("成年")
      if (age >= 60) {
        println("老年")
      } else {
        if (age < 35) {
          println("青年")
        } else {
          println("中年")
        }
      }
    } else {
      println("未成年")
    }

  }
}

