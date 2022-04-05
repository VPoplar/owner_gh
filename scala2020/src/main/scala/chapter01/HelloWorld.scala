package chapter01

/**
  * Author: LiuZheHui
  * CreateTime: 2022-02-19 11:37:00
  * Desc: 
  */
// object:关键字，声明一个单例对象（伴生对象）
object HelloWorld {
  /*
    main方法：从外部可以直接调用执行的方法
    def 方法名称(参数名：参数类型): 返回值类型 = {方法体}
    备注：如果参数是个函数，则返回值类型是函数的输入到输出
    Unit表示没有返回值
   */
  def main(args: Array[String]): Unit = {
    println("Hello World")
    System.out.println("hello scala from java")
  }


}
