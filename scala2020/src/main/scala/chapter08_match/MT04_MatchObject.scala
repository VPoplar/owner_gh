package chapter08_match

import chapter08_match.Student
/**
  * Author: LiuZheHui
  * CreateTime: 2022-04-01 20:14:00
  * Desc: 匹配对象
  */
object MT04_MatchObject {
  def main(args: Array[String]): Unit = {
    val student = new Student("alice",19)
    // 针对对象实例的内容进行匹配
    val result = student match {
      case Student("alice", 19) => "alice 19"
      case _ => "else"
    }
   println(result) // alice 19
    // todo
  }

}
// 定义一个类
class Student(val name:String,val age:Int)
// 定义伴生对象
object Student{
  def apply(name:String,age:Int):Student = new Student(name,age)
  // 必须定义一个unapply方法，用来对对象属性进行拆解
  def unapply(student: Student): Option[(String, Int)] = {
    if(student == null){
      None
    } else {
      Some(student.name,student.age)
    }
    }
  }

