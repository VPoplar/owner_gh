package chapter07_collection

/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-20 11:38:00
  * Desc: 高级函数 reduce,fold等
  */
object CC15_HighLevelFunc_reduce {
  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,4)
    // 1 reduce
    println(list.reduce(_ + _))  // 10
    println(list.reduceLeft(_ + _)) // 10
    println(list.reduceRight(_ + _)) // 10
    println("-----------------------------")
    println(list.reduce(_ - _)) // -8
    println(list.reduceLeft(_ - _)) // -8
    println(list.reduceRight(_ - _)) // -2  ; 1-(2-(3-4))
    //todo
    //2 fold 需要传入一个初始的参数
    println(list.fold(10)(_ + _)) // 20
    println(list.foldLeft(10)(_ + _)) // 20
    println(list.foldRight(10)(_ + _)) // 20
    println("----------------------")
    println(list.fold(10)(_ - _)) // 0 ; 10-1-2-3-4
    println(list.foldLeft(10)(_ - _)) // 0; 10-1-2-3-4
    println(list.foldRight(10)(_ - _)) // 8; 1-(2-(3-(4-10)))

  }

}
