package chapter06_object

/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-06 09:39:00
  * Desc: 构造器-有参
  */
object OB06_constructorParams {
  def main(args: Array[String]): Unit = {
    val student2 = new Student2
    student2.name = "bob"
    student2.age = 12
    println(s"student2: name = ${student2.name}, age = ${student2.age}")
    val student3 = new Student3("alice",13)
    println(s"student3: name = ${student3.name}, age = ${student3.age}")
    val student4 = new Student4("lily",33)
    student4.printInfo()
    val student5 = new Student5("bob", 20)
    println(s"student3: name = ${student5.name}, age = ${student5.age}")
    val student6 = new Student6("mini",33,"feitian")
    student6.printInfo()
  }
}

// 定义类
// 无参构造器
class Student2{
  // 单独定义属性
  var name:String = _
  var age:Int = _
}
// 上面定义等价于
class Student3(var name:String,var age:Int)
// 主构造参数无修饰
class Student4(name:String, age:Int){
  def printInfo():Unit = {
    println(s"student4: name = ${name}, age = $age")
  }
}
//class Student4(_name: String, _age: Int){
//  var name: String = _name
//  var age: Int = _age
//}
class Student5(val name: String, val age: Int)
class Student6(var name:String,var age:Int){
  var school:String = _

  def this(name: String, age: Int,school:String){
    this(name,age)
    this.school = school
  }
  def printInfo():Unit = {
    println(s"Student6 $name $age $school")
  }
}
