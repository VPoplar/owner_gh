package chapter06_object

/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-06 11:08:00
  * Desc: 继承
  */
object OB07_inherit {
  def main(args: Array[String]): Unit = {
    val student1 = new Student7("alice",33)  // 1,2,3
    println("--------------------------------------")
    val student2 = new Student7("bob",33,"1234")
    println("--------------------------------------")  // 1,2,3,4
  }
}

// 创建一个父类
class Person7(){
  var name:String = _
  var age:Int = _
  println("1 父类的主构造方法调用")
  def this(name:String,age:Int){
    this()
    println("2 父类的辅助构造方法调用")
    this.name = name
    this.age = age
  }
  // 打印信息
  def printInfo():Unit = {
    println(s"Person7 $name $age")
  }
}
// 子类继承父类
class Student7(name:String,age:Int) extends Person7(name,age){
  var stuNo:String = _
  println("3 子类的主构造方法调用")
  def this(name:String,age:Int,stuNo:String){
    this(name,age)
    this.stuNo = stuNo
    println("4 子类的辅助构造方法调用")
  }

  override def printInfo(): Unit = {
    println(s"Student7: $name $age $stuNo")
  }
}
