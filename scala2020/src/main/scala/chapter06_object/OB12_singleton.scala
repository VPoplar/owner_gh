package chapter06_object

/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-07 21:10:00
  * Desc: 单例对象；饿汉式和懒汉式
  */
object OB12_singleton {
  def main(args: Array[String]): Unit = {
    val student1 = Student12.getInstance()
    student1.printInfo()

  }

}
class Student12 private(val name: String, val age: Int){
  def printInfo():Unit={
    println(s"student: name = ${name}, age = $age,school=${Student11.school}")
  }
}
// 饿汉式
//object Student12{
//  private val student12 = new Student12("bob",12)
//  def getInstance():Student12 = student12
//}
// 懒汉式:调用的时候才执行
object Student12{
  private var student12:Student12 = _
  def getInstance():Student12 = {
    if(student12==null){
      // mary = new Student12("mary",12)
    }
    student12
  }
}
