package spark_sql

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, sql}
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

object SQL_01_base {
  def main(args: Array[String]): Unit = {
    // TODO 创建 spark-sql运行的环境
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkSQL")
    val spark: SparkSession = new SparkSession.Builder().config(conf).getOrCreate()
    import spark.implicits._
    // TODO 执行逻辑操作
    // TODO DataFrame
    val df: DataFrame = spark.read.json("datas\\test.json")
    df.show()
    // DataFrame => SQL
    df.createOrReplaceTempView("user")
    spark.sql("select * from user").show()
    spark.sql("select age,name from user").show()
    spark.sql("select avg(age) from user").show
    // DataFrame => DSL
    // 在使用DataFrame时，如果涉及到转换操作，需要引入转换规则
    // import spark.implicits._
    df.select("age","name").show()
    df.select($"age" + 1).show()
    df.select('age + 1).show()
    // TODO DataSet
    // DataFrame其实是特定泛型的DataSet
    val seq: Seq[Int] = Seq(1,2,3,4)
    val ds: Dataset[Int] = seq.toDS()
    ds.show()
    // RDD <=> DataFrame
    val rdd: RDD[(Int, String, Int)] = spark.sparkContext.makeRDD(List((1, "zhangsan", 30), (2, "lisi", 40)))
    val rdd2df: DataFrame = rdd.toDF("id","name","age")
    val df2rdd: RDD[Row] = rdd2df.rdd
    // DataFrame <=> DataSet
    val df2ds: Dataset[User] = df.as[User]
    val ds2df: DataFrame = df2ds.toDF()
    // RDD <=> DataSet
    val rdd2ds: Dataset[User] = rdd.map {
      case (id, name, age) => {
        User(id, name, age)
      }
    }.toDS()
    val ds2rdd: RDD[User] = rdd2ds.rdd

    // TODO 关闭环境
    spark.close()
  }
  case class User(id:Int,name:String,age:Int)
}
