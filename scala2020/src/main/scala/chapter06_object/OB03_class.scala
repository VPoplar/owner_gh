package chapter06_object

import scala.beans.BeanProperty

/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-02 21:38:00
  * Desc: 类
  */
object PB03_class {
  def main(args: Array[String]): Unit = {
    // 创建一个学生对象
    val student = new Student()
    // println(student.name)   私有属性不能直接访问
    println(student.age)
    println(student.sex)
  }

}
// 定义一个学生类
class Student{
  // 定义属性
  private var name:String = "alice"
  @BeanProperty
  var age:Int = _   // 默认是0，如果是double类型的话默认是0.0
  var sex:String = _   // 默认为null
}