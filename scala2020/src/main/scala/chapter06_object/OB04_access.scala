package chapter06_object

/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-06 08:54:00
  * Desc: 
  */
object OB04_access {
  def main(args: Array[String]): Unit = {
    // 创建对象
    val person = new Person()
    // 调用属性
    //    person.idCard    // error
    //    person.name    // error
    println(person.age)
    println(person.sex)

    // 调用方法
    println(person.printInfo())  // 一般打印方法时，如果方法的返回值是空的话，那么就会打印()

    val worker = new Worker()
    println(worker.age)
    println(worker.sex)
    println(worker.printInfo())
  }
}

// 定义一个子类继承Person
class Worker extends Person{
  override def printInfo(): Unit = {
   // println(idCard)  // error
    name = "bob"
    age = 13
    sex = "female"
    println(s"Worder:$name $sex $age")
  }
}
