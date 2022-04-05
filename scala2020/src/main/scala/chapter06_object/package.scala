
/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-02 21:13:00
  * Desc: 包对象
  */
package object chapter06_object {
  // 定义当前包共享的属性和方法
  val commonValue = "飞天"
  def commonMethod() = {
    println(s"我们在${commonValue}学习")
  }
}
