package chapter08_match

/**
  * Author: LiuZheHui
  * CreateTime: 2022-04-04 13:54:00
  * Desc: 偏函数
  */
object MT06_PartialFunction {
  def main(args: Array[String]): Unit = {
    val list: List[(String, Int)] = List(("a", 12), ("b", 35), ("c", 27), ("a", 13))
    // 实现集合中的元素(元组)的value值乘以2
    // 1 map转换
    val list2: List[(String, Int)] = list.map(tuple => (tuple._1,tuple._2 * 2))
    println(list2) // List((a,24), (b,70), (c,54), (a,26))
    // 2 用模式匹配对元组赋值，实现功能
    val list3: List[(String, Int)] = list.map(
      tuple => {
        tuple match {
          case (key, value) => (key, value * 2)
        }
      }
    )
    println(list3)
    // 2.2 用lambda表达式的写法
    val list4: List[(String, Int)] = list.map{
      case (key, value) => (key, value * 2)
    }
    println(list4)


    // 偏函数的应用：求绝对值
    // 对输入数据分为不同的情形：正、负、0
    val positiveAbs:PartialFunction[Int,Int] = {
      case x if x>0 => x
    }
    val negativeAbs:PartialFunction[Int,Int] = {
      case x if x<0 => -x
    }
    val zeroAbs:PartialFunction[Int,Int] = {
      case 0 => 0
    }
    def abs(x:Int):Int = (positiveAbs orElse negativeAbs orElse  zeroAbs) (x)
    println(abs(3)) // 3
    println(abs(-3)) // 3
    println(abs(0)) // 0


    // todo
  }
}
