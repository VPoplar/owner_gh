package chapter08_match

/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-27 18:00:00
  * Desc: 模式匹配-匹配常量和类型
  */
object MT02_MatchType {
  def main(args: Array[String]): Unit = {
      // 1 匹配常量
      def describeConst(x:Any):String = x match {
        case 1 => "Int 1"
        case "hello" => "String hello"
        case true => "Boolean true"
        case '+' => "Char +"
        case _ => " "
      }
    println(describeConst(1)) // Int 1
    println(describeConst("hello")) // String hello
    println(describeConst('+')) // Char +
      // 2 匹配类型
      def descType(x:Any) : String = x match {
        case i:Int => "Int i"
        case s:String => "String s"
        case arr:Array[Int] => "Array[Int] +" + arr.mkString(",")
        case list:List[String] => "List" + list
        case a => "Something Else"+ a
      }
    println(descType(34)) // Int i
    println(descType("lalla")) // String s
    println(descType(Array(1,2,3,4))) // Array[Int] +1,2,3,4
    println(descType(List("add","ddd"))) // ListList(add, ddd)
    // 3 匹配数组
    for(arr <- List(
      Array(0),
      Array(1, 0),
      Array(0, 1, 0),
      Array(1, 1, 0),
      Array(2, 3, 7, 15),
      Array("hello", 1, 30)
    )){
      val result = arr match {
        case Array(0) => "0"
        case Array(1,0) => "Array(1,0)"
        case Array(x,y) => "Array:"+x+","+y //匹配两元数组
        case Array(0,_*) => "匹配以0开头的数组"
        case Array(x,1,z) => "匹配中间为1的三元数组"
        case _ => "something else"
      }
      println(result)
    }
    // 4 匹配列表
    for(list <- List(
      List(0),
      List(1, 0),
      List(0, 0, 0),
      List(1, 1, 0),
      List(88),
      List("hello")
    )){
     val result = list match {
       case List(0) => "0"
       case List(x, y) => "List(x, y): " + x + ", " + y
       case List(0, _*) => "List(0, ...)"
       case List(a) => "List(a): " + a
       case _ => "something else"
      }
      println(list)
    }
    println("--------------------------------------")
    // 方式2
    val list1 = List(1, 2, 5, 7, 24)
    val list = List(24)
    list1 match {
      case first :: second :: rest => println(s"first:$first,second:$second,rest:$rest") // first:1,second:2,rest:List(5, 7, 24)
      case _ => println("something else")
    }
    list match {
      case first :: second :: rest => println(s"first:$first,second:$second,rest:$rest")
      case _ => println("something else") // something else
    }
    println("--------------------------------------")
    // 5 匹配元组
    for(tuple <- List(
      (0, 1),
      (0, 0),
      (0, 1, 0),
      (0, 1, 1),
      (1, 23, 56),
      ("hello", true, 0.5)
    )){
      val result = tuple match {
        case (a, b) => "" + a + ", " + b
        case (0, _) => "(0, _)"
        case (a, 1, _) => "(a, 1, _) " + a
        case (x, y, z) => "(x, y, z) " + x + " " + y + " " + z
        case _ => "something else"
      }
    println(result)
    }

    // todo
  }
}
