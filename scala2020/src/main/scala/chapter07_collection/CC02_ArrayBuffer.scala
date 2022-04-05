package chapter07_collection
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-13 19:54:00
  * Desc: 可变数组 ArrayBuffer()
  */
object CC02_ArrayBuffer {
  def main(args: Array[String]): Unit = {
    // 1 创建可变数组
    val arr1: ArrayBuffer[Int] = new ArrayBuffer[Int]()  // 默认是数组的长度是16
    val arr2: ArrayBuffer[Int] = ArrayBuffer(1,2,3)
    println(arr1)  // ArrayBuffer()
    println(arr2)  // ArrayBuffer(1, 2, 3)  打印的不是一个地址,默认调用了toString()方法
    println(arr2.toString())  // ArrayBuffer(1, 2, 3)  打印的不是一个地址
   // 2 访问元素
    // println(arr1(0))  // 数组越界异常 java.lang.IndexOutOfBoundsException
    println(arr2(1))  // 2
    println(arr2(2))  // 3
    arr2(0) = 0
    println(arr2(0))  // 0
    arr2(0) = 1
    // 3 添加元素
    // 如果是用 :+ 则会生成一个新的数组，应该使用 +=
    val newArr: ArrayBuffer[Int] = arr2 :+ 4
    println(newArr)  // ArrayBuffer(1, 2, 3, 4)
    println(arr2)  // ArrayBuffer(1, 2, 3)
    println("-----------------")
    val newArr2: ArrayBuffer[Int] = arr2 += 4  // 往后添加元素
    println(newArr2)  // ArrayBuffer(1, 2, 3, 4)
    println(arr2)  // ArrayBuffer(1, 2, 3, 4)
    println(arr2 == newArr2)  // true
    0 +=: arr2      // 往前添加
    println(arr2)  // ArrayBuffer(0, 1, 2, 3, 4)
    // 另外一种方式添加
    arr2.append(5)  // 往后添加元素
    println(arr2)  //  ArrayBuffer(0, 1, 2, 3, 4, 5)
    arr2.prepend(-1)  // 往前添加元素
    println(arr2)  // ArrayBuffer(-1, 0, 1, 2, 3, 4, 5)
    arr2.append(6,7)
    println(arr2)  //  ArrayBuffer(-1, 0, 1, 2, 3, 4, 5, 6, 7)
    arr2.insert(0,-3,-2)  // 指定位置添加，在第0个位置添加 -2,-1
    println(arr2) // ArrayBuffer(-3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7)
    val arr4: ArrayBuffer[Int] = ArrayBuffer(8,9)
    arr2.insertAll(11,arr4) // 指定位置添加所有的元素
    println(arr2)  // ArrayBuffer(-3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    // 4 删除元素
    arr2.remove(11,2) // 指定位置移除几个元素
    println(arr2)  // ArrayBuffer(-3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7)
    arr2.remove(0)
    println(arr2) //  ArrayBuffer(-2, -1, 0, 1, 2, 3, 4, 5, 6, 7)
    arr2 -= 0  // 移除指定的元素值
    println(arr2) // ArrayBuffer(-2, -1, 1, 2, 3, 4, 5, 6, 7)
    // 5 可变数组转换为不可变数组 toArray
    val im_arr: Array[Int] = arr2.toArray
    println(im_arr.mkString(","))  // -2,-1,1,2,3,4,5,6,7
    println(arr2) // ArrayBuffer(-2, -1, 1, 2, 3, 4, 5, 6, 7)
    // 6 不可变数组转换为可变数组
    val buffer: mutable.Buffer[Int] = im_arr.toBuffer
    println(buffer)  // ArrayBuffer(-2, -1, 1, 2, 3, 4, 5, 6, 7)
    println(im_arr)  // [I@1593948d


  }
}
