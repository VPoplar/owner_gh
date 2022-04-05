package chapter05_function

/**
  * Author: LiuZheHui
  * CreateTime: 2022-02-25 18:16:00
  * Desc: 高阶函数
  */
object PC06_highOrderFunc {
  def main(args: Array[String]): Unit = {
    // 示例函数
    def f(n:Int):Int = {
      println("f函数被调用")
      n + 1
    }
    def fun():Int = {
      println("func函数被调用")
      1
    }

    val result: Int = f(123)
    println(result)
    println("-----------------------")
    //TODO 1 函数作为值传递
    val f1:Int=>Int = f
    val f2 = f _   //  _ 表示函数的类型和f一样
    println(f(123))   // 124
    println(f1)  // chapter05_function.PC06_highOrderFunc$$$Lambda$5/653687670@7f560810  内存中的地址
    println(f1(12)) // 13
    println(f2)  // chapter05_function.PC06_highOrderFunc$$$Lambda$6/356473385@69d9c55   内存中的地址
    println(f2(22)) // 23
    println("---------------------")
    val f3:()=> Int = fun
    val f4 = fun _
    println(f3)  // chapter05_function.PC06_highOrderFunc$$$Lambda$7/1638172114@6276ae34
    println(f3())  // 1
    println(f4)  // chapter05_function.PC06_highOrderFunc$$$Lambda$8/972765878@7946e1f4
    println(f4()) // 1
    println("----------------------------------")
    //TODO 2 函数作为参数传递：相当于参数值和逻辑操作都是自定义的
    def dualEval(op:(Int,Int)=>Int,a:Int,b:Int) : Int = {
      op(a,b)
    }
    def add(a:Int,b:Int):Int={
      a+b
    }
    println(dualEval(add,12,13))  // 25
    println(dualEval((a,b)=> a-b,13,12))  // 1
    // println(dualEval((a,b)=> _-_,13,12))  1
    // println(dualEval(_ - _,13,12))  1
    println("-------------------")
    //TODO 2 函数作为返回值返回
    def f5():Int=>Unit = {
      def f6(a:Int):Unit={
        println("f6被调用"+a)
      }
      f6
    }
    println(f5()) // chapter05_function.PC06_highOrderFunc$$$Lambda$11/1778535015@7921b0a2
    val f7 = f5()
    println(f7)  // chapter05_function.PC06_highOrderFunc$$$Lambda$11/1778535015@7921b0a2
    println(f7(12))  // f6被调用12 \n ()
    println(f5()(12))  // f6被调用12 \n ()




  }
}
