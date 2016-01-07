package us.marek.meetup.w2v

import W2VHelper.withSpark
import org.apache.spark.SparkContext
import org.apache.spark.mllib.feature.Word2VecModel
import scala.io.StdIn.readLine
import scala.util.{Failure, Try, Success}

object W2VPrediction extends App {


  withSpark("Word2Vec Prediction", 4) {

    sc: SparkContext =>

      val model = Word2VecModel.load(sc, Config.modelPath)
      matches(model, 10)

  }

  def matches(model: Word2VecModel, numSynonyms: Int): Unit = {

    readLine("\nEnter word: ") match {

      case "" =>
        println("Done")

      case word =>
        model.findSynonyms(word.toLowerCase, numSynonyms).foreach {

          case (token, similarity) =>
            println(s"word: $token, similarity: $similarity")
        }

        Try(matches(model, numSynonyms)) match {

          case Success(_) =>
          case Failure(_) => {
            println("No match - try again")
            matches(model, numSynonyms)
          }
        }


    }

  }

}
