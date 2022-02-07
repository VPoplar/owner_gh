package spark_core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Transform_18_kv_aggregateByKey_prc {
  def main(args: Array[String]): Unit = {
    // TODO 创建环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    aggregateByKey()
    println("-----------------")
    // TODO 关闭资源
    sc.stop()

    // TODO aggregateByKey:
      def aggregateByKey(): Unit = {
        val rdd = sc.makeRDD(List(
          ("a", 1), ("a", 2), ("b", 3),
          ("b", 4), ("b", 5), ("a", 6)
        ),2)
        //aggregateByKey[U: ClassTag](zeroValue: U)(seqOp: (U, V) => U,combOp: (U, U) => U)
        // aggregateByKey最终返回的数据应该和初始值的类型保持一致
        //val agg_rdd: RDD[(String, String)] = spark_core.rdd.aggregateByKey("")(_+_,_+_)
        //agg_rdd.collect().foreach(println)
        // 获取相同key数据的平均值 (a,3),(b,4)
        val agg_rdd: RDD[(String, (Int, Int))] = rdd.aggregateByKey((0,0))(
          (t, v) => {
            (t._1 + v, t._2 + 1)
          },
          (t1, t2) => {
            (t1._1 + t2._1, t1._2 + t2._2)
          }
        )
        // mapValues区别于map,只对value进行操作
        val rdd_res: RDD[(String, Int)] = agg_rdd.mapValues {
          case (num, cnt) =>
            num / cnt
        }
        rdd_res.collect().foreach(println)
      }

  }
}
