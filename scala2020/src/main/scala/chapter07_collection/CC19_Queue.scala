package chapter07_collection
import scala.collection.mutable
import scala.collection.immutable.Queue
/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-27 15:53:00
  * Desc: 
  */
object CC19_Queue {
  def main(args: Array[String]): Unit = {
    // 创建一个可变队列
    val queue: mutable.Queue[String] = new mutable.Queue[String]()
    // 进队
    queue.enqueue("a","b","c")
    println(queue) // Queue(a, b, c)
    // 出队,一次出一个
    println(queue.dequeue()) // a
    println(queue) // Queue(b, c)
    println(queue.dequeue()) // b
    println(queue) //
    println(queue.dequeue()) // c
    println(queue) // Queue()

    // 不可变队列
    val queue2: Queue[String] = Queue("a", "b", "c")
    val queue3 = queue2.enqueue("d")
    println(queue2) // Queue(a, b, c)
    println(queue3) // Queue(a, b, c, d)

    // todo
  }

}
