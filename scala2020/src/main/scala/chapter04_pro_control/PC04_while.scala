package chapter04_pro_control

/**
  * Author: LiuZheHui
  * CreateTime: 2022-02-24 22:44:00
  * Desc: while循环-一般不用while
  */
object PC04_while {
  def main(args: Array[String]): Unit = {
    // while
    var i=0
    while (i < 10){
      println("this is while loop "+i)
      i+=1
    }
    // do while 至少会执行一次
    println("-------------------")
    var j = 0
    do{
      println("this is do while loop "+j)
    } while (j<=10)

  }
}
