package chapter05_function

/**
  * Author: LiuZheHui
  * CreateTime: 2022-02-25 10:16:00
  * Desc: 函数定义
  */
object FC02_define {
  def main(args: Array[String]): Unit = {
    // 函数1：无参，无返回值
    def f1():Unit={
      println("无参无返回值")
    }
    println(f1())
    println("------------------")
    // 函数2：无参，有返回值
    def f2():Int={
      println("无参无有回值")
      return 10
    }
    println(f2())
    println("-------------------")
    // 函数3：有参，无返回值
    def f3(name:String):Unit={
      println("有参无返回值"+name)
    }
    println(f3("bob"))
    println("------------------")
    // 函数4：有参，有返回值
    def f4(name:String):String={
      println("有参有返回值"+name)
      return name
    }
    println(f4("bob"))
    println("------------------")
    // 函数5：多参，无返回值
    def f5(name:String,age:Int):Unit={
      println("多参无返回值"+name+ age)
    }
    println(f5("mary",12))
    println("------------------")
    // 函数6：多参，有返回值: 多个参数的类型需要保持一致，或者返回的时候需要保持一致
    def f6(a:Int,b:Int):Int={
      println("多参有返回值 ",a,b)
      return a+b
    }
    println(f6(10,12))
    println("------------------")
  }



}
