package chapter05_function

/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-01 21:05:00
  * Desc: 控制抽象：值调用和名调用(java只有值调用)
  */
object PC11_controlAbstract {
  def main(args: Array[String]): Unit = {
    // 1 值调用:把计算后的值传递过去
    def f1(a:Int):Unit={
      println("a="+a)
      println("a="+a)
    }
    f1(23)
    def f2():Int={
      println("f2被调用")
      12
    }
    println("----------------")
    f1(f2())  // a=12 \n a=12

    // 2 名调用:把代码块传递进去
    def f3(a: =>Int):Unit={
      println("a="+a)
      println("a="+a)
    }
    f3(3) // a=3 /n a=3
    println("----------------")
    f3(f2())  // f2被调用\n a=12 \n f2被调用\n a=12
  }

}
