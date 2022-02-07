package spark_core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Transform_17_kv_aggregateByKey {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    aggregateByKey()
    println("-----------------")
    aggregateByKey_same()
    println("-----------------")
    foldByKey()
    // TODO 关闭资源
    sc.stop()

    // TODO aggregateByKey:
      def aggregateByKey(): Unit = {
        val rdd = sc.makeRDD(List(
          ("a", 1), ("a", 2), ("a", 3), ("a", 4)
        ),2)
        // (a,[1,2]), (a, [3，4])
        // (a, 2), (a, 4)
        // (a, 6)
        // aggregateByKey存在函数柯里化，需要传入两个参数列表
        // 第一个参数列表：传递一个参数表示初始值
        // 第二个参数列表：需要传递2个参数
        //               第一个参数表示分区内的计算规则；
        //               第一个参数表示分区间的计算规则
        rdd.aggregateByKey(0)(
          (x,y) => math.max(x,y),
          (x,y) => x+y
        ).collect().foreach(println)
      }
    // TODO aggregateByKey: 如果规则相同也是可以计算比如求和
    def aggregateByKey_same(): Unit = {
      val rdd = sc.makeRDD(List(
        ("a", 1), ("a", 2), ("a", 3), ("a", 4)
      ),2)
      // (a,[1,2]), (a, [3，4])
      // (a, 3), (a, 7)
      // (a, 11)
      rdd.aggregateByKey(0)(
        (x,y) => x+y,
        (x,y) => x+y
      ).collect().foreach(println)
      // spark_core.rdd.aggregateByKey(0)(_+_,_+_).collect().foreach(println)
    }
    // TODO foldByKey: 如果聚合计算时，分区内和分区间计算规则相同，spark提供了简化的方法
    def foldByKey(): Unit = {
      val rdd = sc.makeRDD(List(
        ("a", 1), ("a", 2), ("a", 3), ("a", 4)
      ),2)
      // (a,[1,2]), (a, [3，4])
      // (a, 3), (a, 7)
      // (a, 11)
      rdd.foldByKey(0)(_+_).collect().foreach(println)

    }


  }
}
