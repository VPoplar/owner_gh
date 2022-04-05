package chapter05_function

/**
  * Author: LiuZheHui
  * CreateTime: 2022-02-25 10:16:00
  * Desc: 
  */
object FC01_fun_method {
  def main(args: Array[String]): Unit = {
    // 定义函数
    def sayHi(name:String):Unit = {
      println("hi",name)
    }
    // 调用函数
    sayHi("mary")
    // 调用对象的方法
    sayHello("lily")
    // 获取方法的返回值
    val bob: String = FC01_fun_method.sayHi("bob")
    println("bob="+bob)
  }
  // 定义对象的方法
  def sayHello(name:String):Unit = {
    println("hello",name)
  }
  def sayHi(name:String):String = {
    println("hello",name)
    return "Hi"
  }


}
