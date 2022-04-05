package chapter01

/**
  * Author: LiuZheHui
  * CreateTime: 2022-02-19 12:07:00
  * Desc: 
  */
class Student(name:String,var age:Int) {
  def printInfo():Unit={
    println(name+""+age+""+Student.school)
  }
}
// 引入伴生对象，里面的属性方法可以直接使用
// val 修饰对象，不能改变对象的引用（ 即：内存地址）  ，可以改变对象属性的值。
// var 修饰对象， 可以修改对象的引用和修改对象的属性值
object Student{
  val school = "shanghaiMiddle"
  def main(args: Array[String]): Unit = {
    val alice = new Student("alice",20)
    val bob = new Student("bob",20)
    alice.printInfo()
    bob.printInfo()
  }
}
