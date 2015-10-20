package exe

import dispatch._, Defaults._
import play.api._
import play.api.libs.json._
import scala.concurrent.Future
import scala.util.{ Success, Failure }
import com.ning.http.client.filter.{ ResponseFilter, FilterContext }
import scala.collection.JavaConverters._
import scala.util.matching.Regex

/**
 * ShangriLa Anime API Server Sora のGETリクエストサンプル
 */
object Main extends App {
  val soraHost = host("api.moemoe.tokyo")

  val apiGenre = "anime"
  val apiVersion = "v1"
  val apiTarget = "master"

  // ShangriLa API Serverの持つ、アニメ情報一覧を取得
  val responseCours: Future[String] = Http(soraHost / apiGenre / apiVersion / apiTarget / "cours" OK as.String)
  responseCours onComplete {

    case Success(content) => {
      val responseJson: JsValue = Json.parse(content)
      println("GET /anime/v1/master/cours json response" + responseJson.toString())
    }
    case Failure(t) => {
      println("An error has occurred: " + t.getMessage)
      sys.exit(-1)
    }
  }

  // 指定されたYYYY年のアニメ1クールから4クールまでの情報を取得（サンプルでは2015年を取得）
  val animeInfo2015 = Http(soraHost / apiGenre / apiVersion / apiTarget / "2015" OK as.String)
  animeInfo2015 onComplete {

    case Success(content) => {
      val responseJson = Json.parse(content)
      println("GET /anime/v1/master/2015 json response" + responseJson.toString())
    }
    case Failure(t) => {
      println("An error has occurred: " + t.getMessage)
      sys.exit(-1)
    }
  }

  // 指定されたYYYY年のXクールの情報を取得（サンプルでは2015年の2クール目を取得）
  val animeInfo2015Cour2 = Http(soraHost / apiGenre / apiVersion / apiTarget / "2015" / "2" OK as.String)
  animeInfo2015Cour2 onComplete {

    case Success(content) => {
      val responseJson = Json.parse(content)
      println("GET /anime/v1/master/2015/2 json response" + responseJson.toString())

      val animeInfo = responseJson.as[List[JsValue]] map { seed =>
        seed.as[Map[String, JsValue]]
      }

      // 取得した情報から、「てさぐれ！部活もの すぴんおふ プルプルんシャルムと遊ぼう」の情報を利用する場合
      val tesagure: List[Map[String, JsValue]] = for (
        anime <- animeInfo if anime("title_short1") == JsString("てさぐれ！部活もの")
      ) yield anime

      println("\n「てさぐれ！部活もの すぴんおふ プルプルんシャルムと遊ぼう」 のアニメ情報")
      tesagure.head.toSeq.sortBy(_._1).foreach { parameter =>

        // valueをString変換してもダブルクォートが付いたままなので、表示前に除去する
        val value = parameter._2.toString().replaceFirst("""^\"(.*)\"$""", "$1")
        println(s"""  ${parameter._1} : ${value}""")
      }
    }
    case Failure(t) => {
      println("An error has occurred: " + t.getMessage)
      sys.exit(-1)
    }
  }

  // 非同期処理の終了
  Thread.sleep(2000)
  sys.exit(0)
}
