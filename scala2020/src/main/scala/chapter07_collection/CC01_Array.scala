package chapter07_collection

/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-13 15:07:00
  * Desc: 不可变数组
  * Memu:不可变的一般就是创建，遍历和查询，而可变的还有增加，删除和更新
  */
object CC01_Array {
  def main(args: Array[String]): Unit = {
    // 1 创建数组
    val arr1: Array[Int] = new Array[Int](10)
    // 另外一种方式
    val arr2: Array[Int] = Array(1,2,3,4,5)  // 底层调用的是apply方法
    println(arr1)  // [I@2cb4c3ab
    println(arr2)  // [I@13c78c0b
    // 2 访问元素
    println(arr1(0)) // 0
    println(arr1(1)) // 0
    println(arr2(0)) // 1
    println(arr2(4)) // 5
    // println(arr2(5)) // 数组越界异常 java.lang.ArrayIndexOutOfBoundsException
    // 3 修改元素的值：注意这里不是修改对象的地址，只是修改值
    arr1(0) = 0
    arr1(1) = 1
    println(arr1(0)) // 0
    println(arr1(1)) // 1
    println("------------------------------")
    // 3 数组的遍历
    // 3.1 普通for循环
    for(i <- 0 until  arr2.length){
      println(arr2(i))
    }
    // indices方法底层调用的就是 0 until length
    for(i <- arr2.indices){println(arr2(i))}
    // 3.2 增强for循环：直接遍历所有的元素
    for(elem <- arr2){println(elem)}
    // 3.2 迭代器
    val iter: Iterator[Int] = arr2.iterator
    if(iter.hasNext){
      println(iter.next())
    }
    println("--------------------")
    // 3.3 调用foreach方法-推荐使用
    arr2.foreach((elem:Int) => println(elem))
    // 简化的写法
    arr2.foreach(println)
    // 通过 mkString 方法，这个是数组内的元素按行输出
    println(arr2.mkString("-")) // 1-2-3-4-5
    // 4 添加元素 :+ 或者 +:：由于arr2是不可变数组，所以添加完元素之后是生成一个新的数组
    val arr3: Array[Int] = arr2.:+ (29)
    val arr4: Array[Int] = arr2 :+ 29      // 往后追加
    println(arr3.mkString(","))  // 1,2,3,4,5,29
    println(arr4.mkString(",")) // 1,2,3,4,5,29
    val arr5: Array[Int]  = 29 +: arr2  // 往后追加
    println(arr5.mkString(",")) // 29,1,2,3,4,5
    val arr6: Array[Any] = arr2 :+ (29,30)
    println(arr6.mkString(",")) // 1,2,3,4,5,(29,30)
    val arr7: Array[Any] = arr2 :+ 29 :+ 30
    println(arr7.mkString(",")) // 1,2,3,4,5,29,30

  }
}
