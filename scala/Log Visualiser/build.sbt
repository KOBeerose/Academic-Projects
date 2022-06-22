name := "structured-streaming-project"
version := "0.1"
scalaVersion := "2.12.0"

val spark2Ver = "2.4.6"
val typesafeConfig = "com.typesafe" % "config" % "1.3.3"
val spark2Sql = "org.apache.spark" %% "spark-sql" % spark2Ver
val elasticsearchHadoop = "org.elasticsearch" % "elasticsearch-hadoop" % "7.6.1"



val kafkaDipendency = "org.apache.spark" %% "spark-sql-kafka-0-10" % "2.4.6"


libraryDependencies ++= Seq(
  kafkaDipendency,
  typesafeConfig,
  spark2Sql,
  elasticsearchHadoop,

)