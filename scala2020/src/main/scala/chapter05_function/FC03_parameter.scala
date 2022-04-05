package chapter05_function

/**
  * Author: LiuZheHui
  * CreateTime: 2022-02-25 10:16:00
  * Desc: 函数参数
  */
object FC03_parameter {
  def main(args: Array[String]): Unit = {
    // 1 可变参数 *
    def f1(str:String*):Unit = {
      println(str)
    }
    f1("hello")   // WrappedArray(hello)
    f1("hello","world")  // WrappedArray(hello, world)
    println("-------------------------")
    // 2 如果参数列表中存在多个参数，那么可变参数一般放在最后
    def f2(str1:String,str:String*):Unit = {
      println("str1="+str1+" str="+str)
    }
    f2("hello")   // str1=hello str=WrappedArray()
    f2("hello","world","happy")  // str1=hello str=WrappedArray(world, happy)
    println("-------------------------")
    // 3 参数默认值，一般将有默认值的参数放置在参数列表的后面
    def f3(name:String = "未知"):Unit = {
      println(name)
    }
    f3()  // 未知
    f3("lily") // lily
    println("-------------------------")
    // 4 带名参数:就是传入参数的时候指定参数名，这样可以不用管参数的顺序
    def f4(name:String = "未知", age:Int):Unit = {
      println(s"name=$name,age=$age")
    }
    f4("bob",12)  // name=bob,age=12
    f4(age=13) // name=未知,age=13
    f4(age=14,name="liya") // name=liya,age=14

}
}