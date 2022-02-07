package spark_sql

import org.apache
import org.apache.spark
import org.apache.spark.{SparkConf, sql}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

object SQL_02_udf {
  def main(args: Array[String]): Unit = {
    // TODO 创建 spark-sql运行的环境
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkSQL")
    val spark: SparkSession = new apache.spark.sql.SparkSession.Builder().config(conf).getOrCreate()
    import spark.implicits._
    // 自定义一个udf函数:添加前缀
    spark.udf.register("prefix_name",(name:String)=> {
      ("name:" + name)
    })
    // TODO 执行逻辑操作
    val df: DataFrame = spark.read.json("datas\\test.json")
    df.createOrReplaceTempView("user")
    spark.sql("select age,prefix_name(name) from user").show
    // TODO 关闭环境
    spark.close()
  }
  case class User(id:Int,name:String,age:Int)
}
