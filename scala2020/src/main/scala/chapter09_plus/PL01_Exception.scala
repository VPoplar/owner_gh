package chapter09_plus

/**
  * Author: LiuZheHui
  * CreateTime: 2022-04-04 14:21:00
  * Desc: 异常的处理
  */
object PL01_Exception {
  def main(args: Array[String]): Unit = {
    try{
      val n = 10/0
    } catch {
      case e:ArithmeticException => {
        println("发生算术异常")
      }
      case e:Exception => {
        println("发生一般异常")
      }
    } finally {
      println("处理结束")
    }
  }

}
