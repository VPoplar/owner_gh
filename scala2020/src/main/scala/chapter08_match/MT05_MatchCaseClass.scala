package chapter08_match

/**
  * Author: LiuZheHui
  * CreateTime: 2022-04-01 21:03:00
  * Desc: 匹配样例类
  */
object MT05_MatchCaseClass {
  def main(args: Array[String]): Unit = {
    val student = new Person("alice",19)
    // 针对对象实例的内容进行匹配
    val result = student match {
      case Person("alice", 19) => "alice 19"
      case _ => "else"
    }
    println(result) // alice 19
    // todo
  }

}

case class Person(name:String,age:Int)