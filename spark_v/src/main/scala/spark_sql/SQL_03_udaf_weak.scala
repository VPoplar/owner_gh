package spark_sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types.{DataType, LongType, StructField, StructType}
import org.apache.spark.sql.{DataFrame, Row, SparkSession}

object SQL_03_udaf_weak {
  def main(args: Array[String]): Unit = {
    // TODO 创建 spark-sql运行的环境
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkSQL")
    val spark: SparkSession = new SparkSession.Builder().config(conf).getOrCreate()
    //TODO 自定义一个udaf函数,计算年龄的平均值
    // 注册函数
    spark.udf.register("age_avg",new MyAvgUDAF())
    // TODO UDAF-弱类型函数实现(出错不太好找bug)，并且不在推荐使用
    val df: DataFrame = spark.read.json("datas\\test.json")
    df.createOrReplaceTempView("user")
    spark.sql("select age_avg(age) from user").show()

    // TODO 关闭环境
    spark.close()
  }
  /*
  自定义udaf函数的步骤
  继承UserDefinedAggregateFunction
  实现8个方法
   */
  class MyAvgUDAF extends UserDefinedAggregateFunction {
    // 1输入数据的结构：Int
    override def inputSchema: StructType = {
      StructType(Array(StructField("age", LongType)))
    }

    // 2 缓冲区的数据结构
    override def bufferSchema: StructType = {
      StructType(Array(
        StructField("age_sum", LongType),
        StructField("age_count", LongType)
      ))
    }

    // 3 函数计算结果的类型 OUT
    override def dataType: DataType = LongType

    // 4 函数的稳定性
    override def deterministic: Boolean = true

    // 5 缓冲区初始化
    override def initialize(buffer: MutableAggregationBuffer): Unit = {
      buffer.update(0, 0L) // 根据索引取
      buffer.update(1, 0L)
    }

    // 6 根据输入的值更新缓冲数据
    override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
      buffer.update(0, buffer.getLong(0) + input.getLong(0))
      buffer.update(1, buffer.getLong(1) + 1)
    }

    // 7 缓冲区数据合并
    override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
      buffer1.update(0, buffer1.getLong(0) + buffer2.getLong(0))
      buffer1.update(1, buffer1.getLong(1) + buffer2.getLong(1))
    }

    // 8 计算平均值
    override def evaluate(buffer: Row): Any = {
      buffer.getLong(0) / buffer.getLong(1)
    }
  }
}
