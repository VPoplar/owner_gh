package chapter05_function

/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-01 21:31:00
  * Desc:  lazy懒执行
  */
object PC13_lazy {
  def main(args: Array[String]): Unit = {

    //lazy懒执行 只有不得不执行的时候才会执行
    lazy val result = add(10,23)
    println("1开始输出")  // 第一个输出
    println("result=",result)  // 第三个输出


    def add(a:Int,b:Int):Int={
      println("add被执行")  // 第二个输出
      a+b
    }
  }

}
