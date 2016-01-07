package us.marek.meetup.w2v

import org.apache.spark._
import org.apache.spark.mllib.feature.{Word2Vec, Word2VecModel}

import W2VHelper.withSpark

object W2VTraining extends App {

  withSpark("Word2Vec Training", 4) {
    sc: SparkContext =>

      val input = sc.textFile(Config.corpusPath).map(line => line.split(" ").toSeq)
      val word2vec = new Word2Vec()

      println("Training model. Please wait...")
      val model = word2vec.fit(input)

      println("Saving model")
      model.save(sc, Config.modelPath)
  }
}

