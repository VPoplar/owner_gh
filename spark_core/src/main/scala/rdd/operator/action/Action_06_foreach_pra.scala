package rdd.operator.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Action_06_foreach_pra {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Action")
    val sc: SparkContext = new SparkContext(conf)
    // TODO   RDD算子中传递的函数是会包含闭包操作，那么就会进行检测功能，可以看源码
      val user = new User()
      val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4),2)
      rdd.foreach(
        num => {
          println("age= " + (num+user.age))
        }
      )
    // TODO 关闭资源
    sc.stop()
  }
/*
   类需要进行序列化，不然会报错
  class User extends Serializable {
    var age :Int = 30
  }
  */
  // 用样例类也行:样例类在编译时，会自动混入序列化特质(实现序列化接口)
  case class User() {
    var age :Int = 30
}

}
