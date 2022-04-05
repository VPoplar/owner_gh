package chapter02_datatype

/**
  * Author: LiuZheHui
  * CreateTime: 2022-02-22 20:06:00
  * Desc: 
  */

object Problem_DataTypeConversion {
    def main(args: Array[String]): Unit = {
      var n: Int = 130
      val b: Byte = n.toByte
      println(b)
    }
  /*
  128: Int类型，占据4个字节，32位
  原码 0000 0000 0000 0000 0000 0000 1000 0000
  补码 0000 0000 0000 0000 0000 0000 1000 0000

  截取最后一个字节，Byte
  得到补码 1000 0000
  表示最大负数 -128

  130: Int类型，占据4个字节，32位
  原码 0000 0000 0000 0000 0000 0000 1000 0010
  补码 0000 0000 0000 0000 0000 0000 1000 0010

  截取最后一个字节，Byte
  得到补码 1000 0010
  对应原码 1111 1110
  -126
   */
}
