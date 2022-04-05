package chapter06_object

/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-10 21:16:00
  * Desc: 特质叠加，就是继承了多个特质并且调用了同样的方法，那么以最后一个继承的特质方法为zhun
  */
object OB15_trait_overlay {
  def main(args: Array[String]): Unit = {
    val student1 = new Student15
    student1.increase()  //  Knowledge15 increase   只会选取一个，从右到左

    // 钻石特质,就是继承的多个特质（他们有本身又继承了共同的特质），这样的话相同的方法都会调用
    val ball = new MyFootBall
    println(ball.describe())  // my ball is a red-foot-ball
  }

}
// 钻石特质
// 定义球类特征
trait Ball{
  def describe():String = "ball"
}
// 定义颜色特征
trait ColorBall extends Ball{
  var color:String = "red"
  override def describe(): String = color + "-"+ super.describe()
}
// 定义种类特征
trait CategoryBall extends Ball {
  var category: String = "foot"
  override def describe(): String = category + "-" + super.describe()
}
// 定义一个自定义球的类
class MyFootBall extends CategoryBall with ColorBall {
  // super[CategoryBall].describe()  如果指定特质，那么就只会调用指定特质的方法
  override def describe(): String = "my ball is a " + super.describe()
}

// 特质叠加
trait Knowledge15{
  var amount:Int = 0
  def increase():Unit = {
    println("Knowledge15 increase")
  }
}
trait Talent15{
  def singing:Unit
  def dancing:Unit
  def increase():Unit = {
    println("Talent15 increase")
  }
}
class Student15 extends Student13 with Talent15 with Knowledge15{
  override def dancing: Unit = println("dancing")

  override def singing: Unit = println("singing")

  override def increase(): Unit = super.increase()
}
