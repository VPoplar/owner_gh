package chapter06_object

/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-06 12:01:00
  * Desc: 多肽-也就是指动态绑定：在scala中属性和方法都是动态绑定的，而在Java中属性是静态绑定的方法是动态绑定的
  * 就是父类引用子类
  */
object OB08_dynamicBind {
  def main(args: Array[String]): Unit = {
    val person:Person8 = new Student8
    println(person.name)  // student
    person.hello()  // student
  }

}

// 定义一个父类
class Person8{
  val name:String = "person"
  def hello():Unit={
    println("hello person")
  }
}
// 定义一个子类
class Student8 extends Person8{
  override val name: String = "student"

  override def hello(): Unit = {
    println("hello student")
  }
}
