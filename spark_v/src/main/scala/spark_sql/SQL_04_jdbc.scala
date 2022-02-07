package spark_sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types.{DataType, LongType, StructField, StructType}
import org.apache.spark.sql.{DataFrame, Row, SaveMode, SparkSession}

object SQL_04_jdbc {
  def main(args: Array[String]): Unit = {
    // TODO 创建 spark-sql运行的环境
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkSQL")
    val spark: SparkSession = new SparkSession.Builder().config(conf).getOrCreate()
    // 读取MySQL数据
    val df = spark.read
      .format("jdbc")
      .option("url", "jdbc:mysql://localhost:3306/sqls")
      .option("driver", "com.mysql.jdbc.Driver")
      .option("user", "root")
      .option("password", "123456")
      .option("dbtable", "student")
      .load()
    df.show

    // 保存数据
    df.write
      .format("jdbc")
      .option("url", "jdbc:mysql://localhost:3306/sqls")
      .option("driver", "com.mysql.jdbc.Driver")
      .option("user", "root")
      .option("password", "123456")
      .option("dbtable", "student1")
      .mode(SaveMode.Append)
      .save()

    // TODO 关闭环境
    spark.close()
  }

}
