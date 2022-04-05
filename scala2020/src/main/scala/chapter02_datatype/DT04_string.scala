package chapter02_datatype

/**
  * Author: LiuZheHui
  * CreateTime: 2022-02-20 09:21:00
  * Desc: 字符串操作
  */
object DT04_string {

  def main(args: Array[String]): Unit = {
    //（1）字符串，通过+号连接
    val name: String = "alice"
    val age: Int = 18
    println(age + "岁的" + name + "在尚硅谷学习")

    // *用于将一个字符串复制多次并拼接
    println(name * 3)
    //（2）printf用法：字符串，通过%传值。
    printf("%d岁的%s现在是个学生\n", age, name)

    // (3) 字符串模板(插值字符串)，通过${变量}获取变量值  s"" ;类似于shell脚本中变量的引用
    println(s"${age}岁的${name}现在在上学")

    val num:Double = 23.2356
    // 格式化模板字符串：第一个数字表示与前面1个字符串的间距，后面一个2表示小数点的长度（会四舍五入）
    println(f"the num is ${num}%1.2f")
    println(f"the num is ${num}%6.2f")  // 比第一个输出多了一个空格
    // 三引号表示字符串，保持多行字符串的原格式输出
    val sql =
      s"""
         |select *
         |from table_test
         |where dt=20210210
       """.stripMargin
    println(sql)

  }

}
