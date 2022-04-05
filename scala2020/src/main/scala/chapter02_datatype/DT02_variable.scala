package chapter02_datatype

/**
  * Author: LiuZheHui
  * CreateTime: 2022-02-20 09:21:00
  * Desc: 变量 val ，var
  * 注意：能用常量的地方不用变量
  */
object DT02_variable {

  def main(args: Array[String]): Unit = {

    // 声明一个变量的通用语法
    var a: Int = 10

    //（1）声明变量时，类型可以省略，编译器自动推导，即类型推导
    var a1 = 10
    val b1 = 23

    //（2）类型确定后，就不能修改，说明Scala是强数据类型语言。
    var a2 = 15    // a2类型为Int
    //    a2 = "hello"   错误的，类型不能修改

    //（3）变量声明时，必须要有初始值
    var a3:Int = 10
    //    var a3: Int  错误的

    //（4）在声明/定义一个变量时，可以使用var或者val来修饰，var修饰的变量可改变，val修饰的变量不可改。
    a1 = 12
    //    b1 = 25

    //（5）var 修饰的对象引用可以改变，val 修饰的对象则不可改变，但对象的状态（值）
    // 却是可以改变的。（比如：自定义对象、数组、集合等等）
    val p1 = new Person("lily",30)
    p1.age = 23
    // p1 = null   错误，val修饰的对象不可以改变
    println(p1.age)
    var p2 = new Person("lily",30)
    p2.age = 33
    println(p2.age)
    p2 = null

  }

}
class Person(name:String,var age:Int)
