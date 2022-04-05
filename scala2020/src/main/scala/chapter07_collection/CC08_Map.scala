package chapter07_collection

/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-18 19:37:00
  * Desc: 键值对-Map
  */
object CC08_Map {
  def main(args: Array[String]): Unit = {
    // 1 创建map
    val map1: Map[String, Int] = Map("a" -> 1,"b" -> 2,"c" -> 3)
    println(map1)  // Map(a -> 1, b -> 2, c -> 3)
    println(map1.getClass)
    // 2 遍历元素
    map1.foreach(println) // (a,1)\n(b,2)\n(c,3)
    map1.foreach((kv:(String,Int)) => println(kv)) // (a,1)\n(b,2)\n(c,3)
    println(map1.mkString(",")) // a -> 1,b -> 2,c -> 3
    // 3 取map中所有的key或者value
    for (key <- map1.keys){
      println(s"$key -- ${map1.get(key)}") // a -- Some(1)\n b -- Some(2) \n c -- Some(3)
    }
    for (value <- map1.values){
      println(s"$value") // 1 \n 2 \n 3
    }
    println("--------------------------")
    //4 访问某一个key的value
    println("a="+map1.get("a")) // a=Some(1)
    println("a="+map1.get("a").get) // a=1
    println("a="+map1.get("d").getOrElse(0)) // a=0
    println("a="+map1("a")) // a=1











    // todo
  }

}
