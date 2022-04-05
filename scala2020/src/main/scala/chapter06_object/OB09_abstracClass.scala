package chapter06_object

/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-06 15:04:00
  * Desc: 抽象类：作用是捕捉子类的通用特性
  * （ 1 ）定义抽象类：abstract class Person{} //通过 abstract 关键字标记抽象类
（ 2 ）定义抽象属性：val|var name:String //一个属性没有初始化，就是抽象属性
（ 3 ）定义抽象方法：def   hello():String //只声明而没有实现的方法，就是抽象方法
  */
object OB09_abstracClass {
  def main(args: Array[String]): Unit = {
    val student9 = new Student9()
    println(student9.name,student9.age)
    student9.eat()
    student9.sleep()
  }

}
// 定义一个抽象类
abstract class Person9{
  // 非抽象属性
  var name:String = "person9"
  // 抽象属性
  var age:Int
  // 非抽象方法
  def eat():Unit = {
    println("eating")
  }
  // 抽象方法
  def sleep():Unit
}
// 定义一个子类实现抽象方法
class Student9 extends Person9{
  // 实现非抽象属性
  //  var name = "student9"  报错,直接使用就好了
  name = "student9"

  // 实现抽象属性
  override var age: Int = 33

  // 实现非抽象方法
  override def eat(): Unit = {
    super.eat()
    println("student9 eat")
  }

  // 实现抽象方法
  def sleep(): Unit = {
    // 打印父类的方法
    println("student9 sleep")
  }
}
