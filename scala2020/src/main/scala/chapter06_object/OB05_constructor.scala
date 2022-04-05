package chapter06_object

/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-06 09:39:00
  * Desc: 构造器-无参，分为主构造器和辅构造器
  */
object OB05_constructor {
  def main(args: Array[String]): Unit = {
    val student = new Student1
    student.Student1()
    println("-----------------------")
    val alice = new Student1("alice")
    println("-----------------------")
    val bob = new Student1("bob",12)

  }

}

// 定义一个学生类,如果无参数的话括号可以省略
class Student1{
  // 定义属性
  var name:String = _
  var age:Int = _
  println("1 主构造方法被调用")

  // 声明辅助构造方法-是没有返回值的
  def this(name:String){
    this()  // 直接调用主构造器
    println("2 辅助构造方法一被调用")
    this.name = name
    println(s"info: $name $age ")
  }
  // 第二个辅助构造方法，会先调用第一个构造方法
  def this(name:String,age:Int){
    this(name)
    println("3 辅助构造方法二被调用")
    // this.name = name
    this.age = age
    println(s"info $name $age")
  }
  def Student1():Unit = {
    println("一般方法被调用")
  }


}
