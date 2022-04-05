package chapter02_datatype

import java.io.{File, PrintWriter}

import scala.io.Source


/**
  * Author: LiuZheHui
  * CreateTime: 2022-02-20 09:21:00
  * Desc: 文件操作
  */
object DT06_fileIO {

  def main(args: Array[String]): Unit = {
    // 1 从文件中读取数据
    Source.fromFile("scala\\src\\main\\resources\\test.txt").foreach(print)
    // 2 将数据写入文件
    val writer: PrintWriter = new PrintWriter(new File("scala\\src\\main\\resources\\test2.txt"))
    writer.write("I'm OK")
    writer.close()
  }

}
