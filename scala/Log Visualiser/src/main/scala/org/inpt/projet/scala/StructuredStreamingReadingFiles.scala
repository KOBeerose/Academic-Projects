package org.inpt.projet.scala

import com.typesafe.config.ConfigFactory
import org.apache.spark.sql.types._
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.elasticsearch.hadoop.cfg.ConfigurationOptions

object StructuredStreamingReadingFiles extends App{

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



  private val indexAndDocType = s"logs-data/$docType"

  private val pathToJSONResource = config.getString("spark.json.resource.path")

  //creating SparkSession object with Elasticsearch configuration
  val sparkSession = SparkSession.builder()
    .config(ConfigurationOptions.ES_NET_HTTP_AUTH_USER, elasticsearchUser)
    .config(ConfigurationOptions.ES_NET_HTTP_AUTH_PASS, elasticsearchPass)
    .config(ConfigurationOptions.ES_NODES, elasticsearchHost)
    .config(ConfigurationOptions.ES_PORT, elasticsearchPort)
    .master(master)
    .appName(appName)
    .getOrCreate()



  val schema = StructType(List(
    StructField("HTTPCODE", StringType, true),
    StructField("SITE", StringType, true),
    StructField("URI", StringType, true),
    StructField("IP", StringType, true)
  ))

  val StreamDF = sparkSession.readStream.option("delimiter", " ").schema(schema)
    .csv("/home/elbatouri/Desktop/TECH-GADGET-RECOMMENDATIONS/structured-streaming/src/main/resources/data")


  StreamDF.writeStream
    .outputMode(outputMode)
    .format(destination)
    .option("checkpointLocation", checkpointLocation)
    .start(indexAndDocType)
    .awaitTermination()



}
