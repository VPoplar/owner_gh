package chapter05_function

/**
  * Author: LiuZheHui
  * CreateTime: 2022-02-27 14:36:00
  * Desc:  高阶函数的小练习
  */
object PC08_caseOther {
  def main(args: Array[String]): Unit = {
  /* 练习1：
      定义一个匿名函数，并将它作为值赋给变量 fun。函数有三个参数，类型分别
  为 Int ，String ，Char ，返回值类型为 Boolean。
  要求调用函数 fun(0, “”, ‘0’)得到返回值为 false ，其它情况均返回 true
   */
    val fun = (i:Int,s:String,c:Char) => {
      if(i==0 && s=="" && c=='0') false else true
    }
    println(fun(0,"",'0'))  // falase
    println(fun(0,"33",'0')) // true
    println(fun(5,"33",'0')) // true



  /*
  练习 2 ： 定义一个函数 func ，它接收一个 Int 类型的参数，返回一个函数（记作 f1 ）。
   它返回的函数 f1 ，接收一个 String 类型的参数，同样返回一个函数（记作 f2 ）。
   函数 f2接  收一个 Char 类型的参数，返回一个 Boolean 的值。
    要求调用函数 func(0) (“”) (‘0’)得到返回值为 false ，其它情况均返回 true。
   */

  def func(i:Int): String=>(Char=>Boolean)={
    def f1(s:String): Char=>Boolean={
      def f2(c:Char):Boolean={
        if(i==0 && s=="" && c=='0') false else true
      }
      f2
    }
    f1
  }
  println("----------------------------------")
  println(func(0)("")('0'))  // false
  println(func(1)("")('0'))  // true
  println(func(2)("")('0'))  // true
  println(func(3)("")('0'))  // true

  // 通过匿名函数实现
  def func1(i:Int): String=>(Char=>Boolean)={
    s => c =>{
        if(i==0 && s=="" && c=='0') false else true
      }
  }
  println(func1(0)("")('0'))  // false
  // 函数柯里化
  def func2(i:Int)(s:String)(c:Char):Boolean = {
    if(i==0 && s=="" && c=='0') false else true
  }
    println(func2(0)("")('0'))  // false



}
}