package chapter06_object

/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-06 08:54:00
  * Desc: 
  */
object OB04_classForAccess {

}

// 定义一个父类
class Person{
  // 定义属性
  private var idCard:String = "32233"   // 只能在当前类使用
  protected var name:String = "alice"   // 只能在当前类或者子类中使用
  var sex:String = "female"
  private[chapter06_object] var age:Int = 13  // 只限在该包下使用
  // 定义方法
  def printInfo():Unit = {
    println(s"Person:$idCard $name $sex $age")
  }
}
