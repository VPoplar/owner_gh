package chapter02_datatype

import java.io.{File, PrintWriter}

import chapter01.Student

import scala.io.Source


/**
  * Author: LiuZheHui
  * CreateTime: 2022-02-20 09:21:00
  * Desc: 数据类型
  */
object DT07_dataType {

  def main(args: Array[String]): Unit = {
    // 1 整数类型
    val a1:Byte = -128
    val a2:Byte = 127
    val a3:Short = 220
    val a4 = 3455  // 默认是 Int
    val a5:Long = 2099939333999933L
    // 2 浮点类型
    val a6:Float =  2.3f
    val a7 = 2.4   // 默认是 Double
    println(a1, a2, a3, a4, a5, a6, a7)
    // 3 字符类型
    val c1:Char = '9'
    val c2:Char = 'a' // 默认的都是 Char 类型
    val b: String = "b"  // 默认的都是 String 类型
    //  控制字符
    val c3 = '\t'  // 制表符
    val c4 = '\n'  // 换行符
    println("abc" + c3 + "def")
    println("abc" + c4 + "def")
    //  转义字符
    val c5 = '\\'    // 表示\自身
    val c6 = '\"'    // 表示"
    println("abc" + c5 + "def")
    println("abc" + c6 + "def")
    //  字符变量底层保存ASCII码; Char和Int可以相互转换
    val i1: Int = c1
    println("i1: " + i1)   //   i1: 57
    val i2: Int = c2
    println("i2: " + i2)  //    i2: 97

    val c7: Char = (i1+1).toChar
    val c8: Char = (i2+1).toChar
    println("c7: " + c7)  //    c7: :
    println("c8: " + c8)  //    c8: b

    // 4 布尔类型
    val isTrue: Boolean = true
    println(true)

    // 5 空类型
    // 5.1 空值Unit
    def m1():Unit = {
      println("m1方法被调用")
    }
    val mm: Unit = m1()
    println(mm)   // ()
    // 5.2 空引用null
    // val n5:Int = null  // error
    var alice = new Student("alice", 20)
    alice = null
    println("alice=" ,alice)  // (alice=,null)
    // 5.3 Nothing;它是所有类型的子类
    def m2(n:Int) : Int = {
      if(n == 0)
        throw new NullPointerException
      else
        return n
    }

    val mmm: Int = m2(1)
    println("mmm= ",mmm)  //   (mmm= ,1)

  }

}
