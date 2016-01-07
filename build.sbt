scalaVersion := "2.11.7"


javacOptions ++= Seq("-source", "1.7", "-target", "1.7")

scalacOptions += "-target:jvm-1.7"

val sparkVer = "1.6.0"

libraryDependencies := Seq(
  "org.apache.spark" %% "spark-core" % sparkVer,
  "org.apache.spark" %% "spark-mllib" % sparkVer
)

resolvers := Seq(
  "Maven Central" at "https://repo1.maven.org/maven2/",
  "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
  "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/"
)