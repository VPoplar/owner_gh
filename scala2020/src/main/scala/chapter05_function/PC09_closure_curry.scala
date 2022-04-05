package chapter05_function

/**
  * Author: LiuZheHui
  * CreateTime: 2022-02-27 20:45:00
  * Desc: 闭包:相当于函数（也是一个对象）会保存在堆内存中，不像java保存在栈内，用完就释放了，但是在scala中还是可以共享的
  * 如果一个函数，访问到了它的外部（局部）变量的值，那么这个函数和他所处的 环境，称为闭包
  * 柯里化：把一个参数列表的多个参数
  */
object PC09_closure_curry {
  def main(args: Array[String]): Unit = {

    def add(a:Int,b:Int):Int = {
      a+b
    }
    // 考虑固定加一个数的场景
    def addFour(a:Int):Int = {
      4 + a
    }
    // 考虑扩展加一个数的场景
    def addFive(a:Int):Int = {
      5 + a
    }
    // 将固定加数作为一个固定参数传入
    def addSix(): Int=>Int = {
      val b=4
      def add2(a:Int):Int = {
        a+b
      }
      add2
    }
    // 将固定加数作为一个函数参数传入
    def addSeven(a:Int):Int=>Int = {
      def add2(b:Int):Int= {
        a+b
      }
      add2
    }
    println(addSeven(3)(4))  // 7
    println("-------------------")
    val f1: Int => Int = addSeven(7)  // 12
    val f2: Int => Int = addSeven(8)  // 13
    println(f1(5))
    println(f2(5))
    println("---------------------")

    // 4 用lambda表达式简写
    def addEight(a:Int):Int=>Int = {
      (b:Int) => a+b
    }
    def addNine(a:Int):Int=>Int = {
      b => a+b
    }
    def addTen(a:Int):Int=>Int = a + _
    // 5 柯里化:相当于是把内层的参数全都抽取出来了
    def addEleven(a:Int)(b:Int):Int = {
      a+b
    }
    println(addEleven(35)(24))

  }

}
