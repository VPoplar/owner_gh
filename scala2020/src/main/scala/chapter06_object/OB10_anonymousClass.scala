package chapter06_object

/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-06 15:41:00
  * Desc: 匿名子类：就是不需要额外在定义一个类去继承抽象类，直接在使用的时候new一个出来
  */
object OB10_anonymousClass {
  def main(args: Array[String]): Unit = {
    val dog = new Dog {
      override def run(): Unit = {
        println("dog is running")
      }

      override var name: String = "honoda"
    }
    println(dog.name)
    dog.run()

  }

}
// 定义一个抽象类
abstract class Dog{
  var name:String
  def run():Unit
}
