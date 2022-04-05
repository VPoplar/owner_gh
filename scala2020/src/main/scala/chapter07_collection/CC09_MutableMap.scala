package chapter07_collection
import scala.collection.mutable
/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-18 19:37:00
  * Desc: 键值对-Map,可变的，无序的
  */
object CC09_MutableMap {
  def main(args: Array[String]): Unit = {
    // 1 创建map
    val map1: mutable.Map[String, Int] = mutable.Map("a" -> 1,"b" -> 2,"c" -> 3)
    println(map1)  // Map(a -> 1, b -> 2, c -> 3)
    println(map1.getClass) // class scala.collection.mutable.HashMap
    // 2 添加元素
    map1.put("d",4)  // 底层调用的就是 += 方法
    println(map1) // Map(b -> 2, d -> 4, a -> 1, c -> 3)
    map1 += (("e",5))
    println(map1)  // Map(e -> 5, b -> 2, d -> 4, a -> 1, c -> 3)
    // 3 删除元素
    map1.remove("e")
    println(map1)  // Map(b -> 2, d -> 4, a -> 1, c -> 3)
    map1 -= "d"
    println(map1) // Map(b -> 2, a -> 1, c -> 3)
    // 4 访问元素
    println(map1("a")) // 1
    // 5 修改元素
    map1.update("a",0)
    println(map1)  // Map(b -> 2, a -> 0, c -> 3)
    // 6 合并两个map
    val map2: mutable.Map[String, Int] = mutable.Map("d" -> 4,"e" -> 5)
    val map3 :Map[String, Int] = Map("f" -> 6,"g" -> 7)
    map1 ++= map2
    println(map1) // Map(e -> 5, b -> 2, d -> 4, a -> 0, c -> 3)
    map1 ++= map3
    println(map1) // Map(e -> 5, b -> 2, d -> 4, g -> 7, a -> 0, c -> 3, f -> 6)
    val map4: Map[String, Int] = map3 ++ map2
    println(map4) // Map(f -> 6, g -> 7, e -> 5, d -> 4)

    // todo
  }

}
