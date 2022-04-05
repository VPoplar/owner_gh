package chapter08_match

/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-27 18:00:00
  * Desc: 模式匹配-基础知识
  */
object MT01_PatternMatchBase {
  def main(args: Array[String]): Unit = {
    // 1 定义基本语法
    val x = 5
    val y = x match {
      case 1 => "one"
      case 2 => "two"
      case 3 => "three"
      case 4 => "four"
      case _ => "others"
    }
    println(y)
    // 2 用模式匹配实现简单二元运算
    val a = 25
    val b = 13
    def matchDualOp(op:Char):Int = op match {
      case '+' => a+b
      case '-' => a-b
      case '*' => a*b
      case '/' => a/b
      case '%' => a%b
      case _ => -1
    }
    println(matchDualOp('+'))
    // 3 模式守卫:如果想要表达某个范围的数据，就需要在模式匹配中增加条件守卫
    // 求一个整数的绝对值
    def abs(num:Int):Int = {
      num match {
        case i if i>=0 => i
        case i if i<0 => -i
      }
    }
    println(abs(-4))  // 4
    // todo
  }
}
