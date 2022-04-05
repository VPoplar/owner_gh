package chapter05_function

/**
  * Author: LiuZheHui
  * CreateTime: 2022-02-25 14:27:00
  * Desc: lambda-匿名函数使用及简化原则
  */
object PC05_lambda {
  def main(args: Array[String]): Unit = {

    val fun = (name: String) => {
        println(name)
      }
    fun("sky")  // sky
    println("--------------------------")
    // 定义一个函数，将函数作为参数传入
    def f(func :String=>Unit):Unit = {
      func("say hello")
    }
    f(fun)  // say hello
    f((name: String) => {
      println(name)
    })   // say hello
    println("--------------------------")
    // 匿名函数的简化原则
    // 1 参数的类型可以省略，会根据形参自动推导
    f((name) => {println(name)})
    println("--------------------------")
    // 2 类型省略之后，发现只有一个参数，则圆括号可以省略；其他情况：没有参数和参数超过1的永远不能省略圆括号。
    f(name => {
      println(name)
    })
    println("--------------------------")
    // 3 匿名函数如果只有一行，则大括号也可以省略
    f(name => println(name))
    println("--------------------------")
    // 4 如果参数只出现一次，则参数省略且后面参数可以用_代替
    f(println(_))
    println("--------------------------")
    // 5 如果可以推断出，当前传入的println是一个函数体，而不是调用语句，可以直接省略下划线
    f(println)
    println("--------------------------")
    // TODO 示例;定义一个二元函数的函数，只操作1和2两个数，但是具体运算通过参数传入，相当于把计算的逻辑传进去
    // TODO 也就是说能够根据已知的数据进行自定义的逻辑计算，所以Spark和Flink经常用到
    def dualFunc(func:(Int,Int)=>Int): Int ={
      func(1,2)
    }
    val add = (a:Int,b:Int) => a+b
    val minus = (a:Int,b:Int) => a-b
    println(dualFunc(add))
    println(dualFunc(minus))
    println("--------------------------")
    println((a:Int,b:Int) => a+b)
    println((a:Int,b:Int) => a-b)
    println("--------------------------")
    // println((a,b)=> a+b)
    // println((a,b)=> a-b)
    println("--------------------------")
    // println((a,b)=> _+_)
    // println((a,b)=> _-_)
    // println(dualFunctionOneAndTwo((a, b) => b - a))
    // println(dualFunctionOneAndTwo( -_ + _))
  }
}
