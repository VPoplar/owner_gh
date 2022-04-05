package chapter06_object

/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-13 10:20:00
  * Desc: trait扩展：类型检查和转换，枚举和应用类，Type定义新类型
  */
object OB13_trait_extends {
  def main(args: Array[String]): Unit = {
    // 1 类型的检测和转换
    val student:Student17 = new Student17("alice",15)
    student.sayHi()
    student.study()
    val person: Person17 = new Student17("bob",22)
    person.sayHi()
    val nick: Person17 = new Person17("nick",33)
    println("---------------------------------")
    // 2 类型判断
    println("student is person "+student.isInstanceOf[Person17]) // true
    println("student is student "+student.isInstanceOf[Student17]) // true
    println("person is person "+person.isInstanceOf[Person17]) // true
    println("person is student "+person.isInstanceOf[Student17]) // true
    println("nick is person "+nick.isInstanceOf[Person17])  // true
    println("nick is student "+nick.isInstanceOf[Student17])  // false
    // 3 类型转换
    if(person.isInstanceOf[Student17]){
      val newStudent = person.asInstanceOf[Student17]
      newStudent.study()
    }
    println(classOf[Student17])
    println("-----------------------------------")
    // 测试枚举类
    println(WorkDay.monday)
    println(WorkDay.tuesday)
  }
}

// 定义一个类
class Person17(var name:String,var age:Int){
  def sayHi():Unit={
    println("hi from person "+name)
  }
}
// 定义一个学生子类
class Student17(name:String,age:Int) extends Person17(name,age){
  override def sayHi(): Unit = super.sayHi()
  def study():Unit={
    println("student study")
  }
}
// 定义枚举类对象
object WorkDay extends Enumeration{
   val monday: WorkDay.Value = Value(1,"Monday")
   val tuesday: WorkDay.Value = Value(2,"Tuesday")
}
// 定义应用对象
object TestApp extends App{  // App类底层实现的是main方法
  println("app start")
  // Type定义新类型
  type MyString = String
  val a:MyString = "1111"
  print(s"a=$a")
}