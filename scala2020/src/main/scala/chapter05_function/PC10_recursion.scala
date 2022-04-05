package chapter05_function

import scala.annotation.tailrec

/**
  * Author: LiuZheHui
  * CreateTime: 2022-02-28 21:07:00
  * Desc: 递归-很好用，但是非常消耗计算资源
  */
object PC10_recursion {
  def main(args: Array[String]): Unit = {
    println(recursion(5))
    println("--------------------------")
    println(tailFact(6))
  }
  // 正常的递归
  def recursion(a:Int):Int = {
    if(a == 0) return 1
    recursion(a-1)*a
  }
  // 递归优化：尾递归实现(相当于把累计的值覆盖到一个参数里面去)
  // 尾递归实现
  def tailFact(n: Int): Int = {
    @tailrec
    def loop(n: Int, currRes: Int): Int = {
      if (n == 0) return currRes
      loop(n - 1, currRes * n)
    }
    loop(n, 1)
  }
}
