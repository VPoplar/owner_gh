package spark_sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.expressions.{Aggregator, MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types.{DataType, LongType, StructField, StructType}
import org.apache.spark.sql._

object SQL_03_udaf_strong {
  def main(args: Array[String]): Unit = {
    // TODO 创建 spark-sql运行的环境
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkSQL")
    val spark: SparkSession = new SparkSession.Builder().config(conf).getOrCreate()
    //TODO 自定义一个udaf函数,计算年龄的平均值

    // TODO UDAF-强类型函数实现
    val df: DataFrame = spark.read.json("datas\\test.json")
    df.createOrReplaceTempView("user")
    // 注册函数
    spark.udf.register("age_avg",functions.udaf(new MyAvgAge()))
    spark.sql("select age_avg(age) from user").show()

    // TODO 关闭环境
    spark.close()
  }

  /*
  自定义聚合函数类：计算年龄的平均值
  自定义udaf函数的步骤
  1 继承org.apache.spark.sql.expressions.Aggregator, 定义泛型
    IN: 输入的数据类型为 Long
    BUF: 缓冲区的数据类型为 Buff
    OUT: 输出的数据类型为Long
  2 实现6个方法
   */
  case class Buff(var age_sum:Long,var age_count:Long)
  class MyAvgAge extends Aggregator[Long, Buff, Long] {
    // 1 初始值或者零值
    override def zero: Buff = {
      Buff(0L,0L)
    }
    // 2 根据输入的数据更新缓冲区的数据
    override def reduce(buff: Buff, in: Long): Buff = {
      buff.age_sum=buff.age_sum+in
      buff.age_count=buff.age_count+1
      buff
    }
    // 3 合并缓冲区
    override def merge(buff1: Buff, buff2: Buff): Buff = {
      buff1.age_sum=buff1.age_sum+buff2.age_sum
      buff1.age_count=buff1.age_count+buff2.age_count
      buff1
    }
    // 4 计算结果
    override def finish(buff: Buff): Long = {
      buff.age_sum / buff.age_count
    }
    // 5 缓冲区的编码操作
    override def bufferEncoder: Encoder[Buff] = Encoders.product
    // 6 输出的编码操作
    override def outputEncoder: Encoder[Long] = Encoders.scalaLong
  }

}
