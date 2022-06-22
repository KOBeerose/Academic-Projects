package org.inpt.projet.scala

import org.apache.spark.sql.SparkSession
import com.typesafe.config.ConfigFactory
import org.apache.spark.sql.functions.{col, from_json}
import org.apache.spark.sql.types._
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.elasticsearch.hadoop.cfg.ConfigurationOptions

object StructuredStreamingKafka extends App {

  private val config = ConfigFactory.load()

  private val master = config.getString("spark.master")
  private val appName  = config.getString("spark.app.name")
  private val elasticsearchUser = config.getString("spark.elasticsearch.username")
  private val elasticsearchPass = config.getString("spark.elasticsearch.password")
  private val elasticsearchHost = config.getString("spark.elasticsearch.host")
  private val elasticsearchPort = config.getString("spark.elasticsearch.port")
  private val outputMode = config.getString("spark.elasticsearch.output.mode")
  private val destination = config.getString("spark.elasticsearch.data.source")
  private val checkpointLocation = config.getString("spark.elasticsearch.checkpoint.location")
  private val index = config.getString("spark.elasticsearch.index")
  private val docType = config.getString("spark.elasticsearch.doc.type")



  private val indexAndDocType = s"log/$docType"


  //creating SparkSession object with Elasticsearch configuration
  val spark = SparkSession.builder()
    .config(ConfigurationOptions.ES_NET_HTTP_AUTH_USER, elasticsearchUser)
    .config(ConfigurationOptions.ES_NET_HTTP_AUTH_PASS, elasticsearchPass)
    .config(ConfigurationOptions.ES_NODES, elasticsearchHost)
    .config(ConfigurationOptions.ES_PORT, elasticsearchPort)
    .master(master)
    .appName(appName)
    .getOrCreate()


  val df = spark.readStream
    .format("kafka")
    .option("kafka.bootstrap.servers", "localhost:9092")
    .option("subscribe", "logs-data")
    .option("startingOffsets", "earliest") // From starting
    .load()

  val dataStream = df.selectExpr("CAST(value AS STRING)")

  val schema = StructType(List(
    StructField("HTTPCODE", StringType, true),
    StructField("SITE", StringType, true),
    StructField("URI", StringType, true),
    StructField("IP", StringType, true)
  ))

  val lineDF = dataStream.select(from_json(col("value"), schema).as("data"))
    .select("data.*")

  lineDF.writeStream
    .outputMode(outputMode)
    .format(destination)
    .option("checkpointLocation", checkpointLocation)
    .start(indexAndDocType)
    .awaitTermination()


}
