package exe

import groovy.json.JsonSlurper
import groovy.util.logging.Slf4j;
import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.Method.GET
import static groovyx.net.http.ContentType.JSON
import static groovyx.net.http.ContentType.TEXT

/**
 * ShangriLa Anime API Server Sora のGETリクエストサンプル
 */
@Slf4j
class Main {

	static main(args) {

		final String SORA_HOST = "http://api.moemoe.tokyo"
		
		final String API_GENRE = "anime"
		final String API_VERSION = "v1"
		final String API_TARGET = "master"
		
 		def http = new HTTPBuilder(SORA_HOST)
		 
 		// ShangriLa API Serverの持つ、アニメ情報一覧を取得
		// レスポンスのJSON文字列を返却する。異常応答の場合はnullが返却される。
		def resJsonText = http.request(GET, TEXT) {
//			uri.path = '/anime/v1/master/cours'
			uri.path = '/' + [API_GENRE, API_VERSION, API_TARGET, "cours"].join("/")
			headers.Accept = 'application/json'
		  
			response.success = { resp, json ->
				assert resp.status == 200
				def jsonString = json.text
				println("GET /anime/v1/master/cours json response: $jsonString")
				jsonString
			}

			response.'404' = { resp -> println "Access denied" }
			response.failure = { resp -> println "Unexpected failure: ${resp.statusLine}" }
		}
		
		if (resJsonText == null) {
			return
		}
		def jsonSlurper = new JsonSlurper()
		def resJsonObj = jsonSlurper.parseText(resJsonText)
		// アニメ情報が保持されている年をリストに格納する
		def yearList = resJsonObj.collect{it.value.year}.unique()
		
		// 指定されたYYYY年のアニメ1クールから4クールまでの情報を取得（サンプルでは2015年を取得）
		def targetYear = 2015
		if (yearList.contains(targetYear)) {
			http.get(
				path : '/' + [API_GENRE, API_VERSION, API_TARGET, targetYear].join("/"),
				contentType : TEXT) { resp, json ->

				println "response status: ${resp.statusLine}"
				println 'Headers: -----------'
				resp.headers.each { h -> println " ${h.name} : ${h.value}" }
				println 'Response data: -----'
				System.out << json.text
				println '\n--------------------'
			}
		}
		
		// 指定されたYYYY年のXクールの情報を取得（サンプルでは2015年の2クール目を取得）
		http.get(
			path : '/' + [API_GENRE, API_VERSION, API_TARGET, "2015", "2"].join("/"),
			contentType : TEXT) { resp, json ->

				def animeInfo2015Cour2 = jsonSlurper.parseText(json.text)

				// 取得した情報から、「てさぐれ！部活もの すぴんおふ プルプルんシャルムと遊ぼう」の情報を利用する場合
				def tesagureInfo = animeInfo2015Cour2.find { it.title_short1 == "てさぐれ！部活もの" }
				println("\n「てさぐれ！部活もの すぴんおふ プルプルんシャルムと遊ぼう」 のアニメ情報")
				tesagureInfo.each {
					println "${it.key} : ${it.value}"
			}
		}
	}
}
