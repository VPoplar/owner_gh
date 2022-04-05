package chapter07_collection

import scala.collection.immutable.Queue
import scala.collection.{immutable, mutable}
import scala.collection.parallel.immutable.ParSeq

/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-27 15:53:00
  * Desc: 并行集合
  */
object CC20_Parallel {
  def main(args: Array[String]): Unit = {
    val result: immutable.IndexedSeq[Long] = (1 to 10).map(
      x => Thread.currentThread().getId
    )
    println(result) // Vector(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
    val result2: ParSeq[Long] = (1 to 10).par.map(
      x => Thread.currentThread.getId
    )
    println(result2) // ParVector(11, 12, 12, 12, 12, 12, 12, 12, 12, 12)
    // todo
  }

}
