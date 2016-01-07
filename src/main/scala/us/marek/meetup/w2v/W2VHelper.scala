package us.marek.meetup.w2v

import org.apache.spark.{SparkConf, SparkContext}

object W2VHelper {

  def withSpark(appName: String, numThreads: Int)(f: SparkContext => Unit): Unit = {

    var sc: SparkContext = null

    try {

      val conf = new SparkConf().setAppName(appName).setMaster(s"local[$numThreads]")
      sc = new SparkContext(conf)
      f(sc)

    } finally {

      if (sc != null) {
        sc.stop()
      }
    }

  }
}
