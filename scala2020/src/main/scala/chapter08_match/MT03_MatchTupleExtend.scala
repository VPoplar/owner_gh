package chapter08_match

/**
  * Author: LiuZheHui
  * CreateTime: 2022-04-01 20:14:00
  * Desc: 匹配元组扩展
  */
object MT03_MatchTupleExtend {
  def main(args: Array[String]): Unit = {
    // 1 在变量声明时匹配
    val (x,y) = (1,2)
    println(s"x:$x,y:$y")
    val List(first,second,_*) = List(1,2,3,4)
    println(s"first:$first,second:$second") // first:1,second:2
    val a::b::c = List(1,2,3,4)
    println(s"a:$a,b:$b,$c") // a:1,b:2,List(3, 4)
    println("-----------------------------")
   // 2 for推导式中进行模式匹配
   val list: List[(String, Int)] = List(("a", 12), ("b", 35), ("c", 27), ("a", 13))
    // 2.1 原本的遍历方式
    for(elem <- list){
      println(elem._1,elem._2)
    }
    // 2.2 将list中的元素直接定义为元组，对变量赋值
    for((word,count) <- list){
      println(word,count)
    }
    // 2.3 可以不考虑某个位置的值，直接遍历key或者value
    for((word,_) <- list) {
      println(word)
    }
    // 2.4 也可以指定某个位置的值必须是多少
    for(("a",value) <- list){
      println(value)
    }
    // todo
  }

}
