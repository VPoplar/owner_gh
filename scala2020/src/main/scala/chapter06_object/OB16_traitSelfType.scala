package chapter06_object

/**
  * Author: LiuZheHui
  * CreateTime: 2022-03-11 21:30:00
  * Desc: trait自身类型
  */
object OB16_traitSelfType {
  def main(args: Array[String]): Unit = {
    val alice = new RegisterUser("alice","123456")
    alice.insert()
  }

}

// 用户类
class User(val name:String,val passward:String)
// 定义一个特质
trait UserDao{
  _: User =>
  def insert():Unit={
    println(s"insert into db ${this.name}")
  }
}
// 定义注册用户类
class RegisterUser(name:String,passward:String) extends User(name,passward) with UserDao