package chapter07_collection
import scala.collection.mutable
/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-17 20:25:00
  * Desc: 可变集合Set，无序，不重复
  */
object CC07_MutableSet {
  def main(args: Array[String]): Unit = {
    // 1 创建set
    val set1: mutable.Set[Int] = mutable.Set(1,2,3,4)
    println(set1) // Set(1, 2, 3, 4)
    // 2 添加元素
    val set2: mutable.Set[Int] = set1 + 5
    println(set2) // 这是生成了一个新的集合，Set(1, 5, 2, 3, 4)
    set1 += 5
    println(set1) // Set(1, 5, 2, 3, 4)
    set1.add(6) // add底层调用的就是 += ，不过add方法有返回值 Boolean
    println(set1) // Set(1, 5, 2, 6, 3, 4)
    val bool1: Boolean = set1.add(7)
    println(bool1) // true
    val bool2: Boolean = set1.add(1) // 因为值重复了，所以没有添加进去，为false
    println(bool2) // false
    // 3 删除元素 -= remove
    set1 -= 6
    println(set1) // Set(1, 5, 2, 3, 7, 4)
    set1.remove(5) //底层调用的就是 -=
    println(set1) // Set(1, 2, 3, 7, 4)
    val bool: Boolean = set1.remove(1)
    println(bool) // true
    // 4 合并两个set
    val set3 = mutable.Set(-1,-2)
    set1 ++= set3
    println(set1) // Set(-2, 2, -1, 3, 7, 4)

  }
}
