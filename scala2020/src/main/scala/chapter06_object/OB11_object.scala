package chapter06_object

/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-06 16:12:00
  * Desc: 伴生对象;g关键字object
  */
object OB11_object {
  def main(args: Array[String]): Unit = {
     // 没有私有构造方法使用的情况
     // val student = new Student11("alice",12)
     // student.printInfo()
    // 有私有构造方法使用的情况:通过伴生对象来获取
    val student1 = Student11.createStudent11("bob",13)
    student1.printInfo()
    println("-------------------")
    val student2 = Student11.apply("mark",22)
    student2.printInfo()
    println("-------------------")
    // 如果用的是apply方法，那么apply可以省略
    val student3 = Student11("nick",33)
    student3.printInfo()

  }
}
// 定义类,私有的构造方法，不能被外部使用
class Student11 private(val name:String,val age:Int){
  def printInfo():Unit={
    println(s"name:$name age:$age school:${Student11.school}")
  }
}
object Student11{
  val school:String = "feitian"
  // 定义一个对象类的实例创建方法
  def createStudent11(name:String,age:Int):Student11 = new Student11(name,age)
  def apply(name:String,age:Int):Student11 = new Student11(name,age)
}
