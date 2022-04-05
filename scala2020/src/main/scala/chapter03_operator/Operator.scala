package chapter03_operator

/**
  * Author: LiuZheHui
  * CreateTime: 2022-02-23 19:10:00
  * Desc: 
  */
object Operator {
  def main(args: Array[String]): Unit = {

    // 1 算术运算符   +,-,*,/-除,%-取模
    val r1 :Int = 10 / 3   // 3
    val r2 :Double = 10 / 3   // 3.0
    val r3 :Double = 10.0 / 3  // 3.3333333333333335
    val r4 :Int = 10 % 3  //  1
    println(r1, r2, r3, r4)

    // 2 关系运算符(比较运算符)  ==,!=,<.>,<=,>=
    val s1:String = "hello"
    val s2:String = new String("hello")
    println(s1==s2)  // true
    println(s1.equals(s2))  // true
    println(s1.eq(s2))  // false   引用的地址是不一样的

    // 3 逻辑运算符  && ,||, !   结果为true或者false
    var a = true
    var b = false
    println("-------------------------------")
    println(a && b)  // false  这个是短路与，如果a是false则不会去计算b的值，因为结果就是false
    println(a & b)   // false  这个是按位与，不会短路，就是a和b的值都会去计算然后再判断 ,一般一个与是不做逻辑判断的
    println(a || b) // true
    println(!(a && b)) // true
    println("-------------")
    // 判断一个字符串是否为空
    def isNotEmpty(str:String):Boolean = {
      // 备注：如果这里用按位与 & ，则会发生空指针异常
      return str != null && !("".equals(str.trim))
    }
    println(isNotEmpty(null))

    // 4 赋值运算符  +=，-=，*=，/= 等等
    //    var b: Byte = 10
    var i: Int = 12
    //    b += 1
    i += 1
    println(i)
    println("------------------------------")
    // 5 位运算符 主要和二进制有关   0 代表false，1代表true
    val m = 60  // 二进制表示为  00111100
    val n = 13  // 二进制表示为  00001101
    println(m & n)  // 按位与运算符 12  00001100
    println(m | n)  // 按位或运算符 12  00111101
    println(m ^ n)  // 按位或运算符 49  00110001   相同的就为0，不相同就为1
    println(~m)  //  按位取反运算符-61  00110001
    println(m << 2)  // 左移运算符 240  00110000
    println(m >> 2)  // 右移运算符 15  00110001
    println(m >>> 2) // 无符号右移 15  00110001

    /*
    6 运算符的本质
      在scala中其实是没有运算符的，所有运算符都是方法
      1) 当调用对象的方法时， 点.可以省略
      2) 如果函数参数只有一个，或者没有参数 ，()可以省略
     */
    val y:Int = 1.+(1)   // 2
    val z:Int = 1 + 1   // 2
    println(y.toString())
    println(y toString())



  }

}
