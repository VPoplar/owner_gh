package chapter04_pro_control

/**
  * Author: LiuZheHui
  * CreateTime: 2022-02-24 20:52:00
  * Desc: 
  */
object PC03_for_case {
  def main(args: Array[String]): Unit = {
    //1需求 9*9乘法口诀
    for(i <- 1 to 9){
      for(j <- 1 to i){
        print(s"$j*$i=${i * j}\t")
      }
      println()
    }
    println("-------------------")
    // 简写成如下
    for(i <- 1 to 9; j <- 1 to i){
      print(s"$j*$i=${j * i}\t")
      if(i==j){
        println()
      }
    }
    println("-------------------------")
    // 2 输出金字塔
    for(line <- 1 to 9; star= 2*line-1; space = 9-line){
      println(" "*space + "*"*star)
    }
    // 第二种方法
    for (stars <- 1 to 17 by 2; spaces = (17 - stars) / 2){
      println(" " * spaces + "*" * stars)
    }
    println("--------------------------")
    // 输出倒金字塔
    for(line <- 1 to 9; star=18-(2*line-1); space=line-1){
      println(" "*space+"*"*star)
    }

  }

}
