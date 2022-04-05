package chapter07_collection
import scala.collection.mutable
/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-27 10:46:00
  * Desc: 
  */
object CC16_MergeMap {
  def main(args: Array[String]): Unit = {
    val map1 = Map("a" -> 1,"b" -> 3,"c" -> 6)
    val map2 = mutable.Map("a" -> 6,"b" -> 2,"c" -> 3,"d" -> 4)
    println(map1 ++ map2) // Map(a -> 6, b -> 2, c -> 3, d -> 4)
    println("------------------------------")
    val map3: mutable.Map[String, Int] = map1.foldLeft(map2)(
      (mergeMap, kv) => {
        val key = kv._1
        val value = kv._2
        mergeMap(key) = mergeMap.getOrElse(key, 0) + value
        mergeMap
      }
    )
    println(map3) // Map(b -> 5, d -> 4, a -> 7, c -> 9)



    // todo
  }

}
