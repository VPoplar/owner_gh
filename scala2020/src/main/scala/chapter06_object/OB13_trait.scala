package chapter06_object

/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-08 20:11:00
  * Desc: trait 特质：单继承多实现，相当于Java中的接口，但是也有区别：
  * Java中的接口里面都是抽象的属性和方法，但是特质中可以有抽象的也可以有具体的属性和方法
  * java 中也会有冲突，对于冲突的属性或者方法直接重写就好了
  */
object OB13_trait {
  def main(args: Array[String]): Unit = {
    val student1 = new Student13
    student1.sayHello()
  }

}
// 定义一个父类
class Person13{
  val name:String = "bob"
  var age:Int = 13
  def sayHello():Unit = {
    println("hello "+name)
  }
  def increase():Unit={
    println("person increase")
  }
}
// 定义一个特质
trait Young{
  // 声明抽象属性和非抽象属性
  var age:Int
  val name:String = "young"
  // 声明抽象方法和非抽象方法
  def play():Unit={
    println(s"young people $name have fun")
  }
  def dating:Unit
}
// 定义一个类继承People13和特质Young
class Student13 extends Person13 with Young{
  // 重写冲突的属性
   override val name: String = "String"

  // 实现抽象方法
  def dating: Unit = {
    println("dating is varr")
  }
  // 重写父类的方法
  override def sayHello(): Unit = {
    super.sayHello()
    println(s"hello from $name")
  }
  def study():Unit = {
    println(s"$name is study")
  }
}
