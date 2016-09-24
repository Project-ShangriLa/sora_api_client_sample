package shangrila

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

/**
 * Created by lowput on 2016/09/22.
 */
data class Sora(
    val title_short2: String,
    val twitter_account: String,
    val public_url: String,
    val title_short1: String,
    val sex: Int,
    val twitter_hash_tag: String,
    val id: Int,
    val sequel: Int,
    val created_at: String,
    val cours_id: String,
    val title: String,
    val title_short3: String,
    val updated_at: String)

interface SoraClient {
    @GET("anime/v1/master/{year}/{number}")
    fun Call(@Path("year") year : String, @Path("number") number : String) : Observable<Array<Sora>>
}

fun main(args: Array<String>) {
    val gson = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()

    val retrofit = Retrofit.Builder()
            .baseUrl("http://api.moemoe.tokyo/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()

    val soraClient = retrofit.create(SoraClient::class.java)

    soraClient.Call("2016", "4")
            .subscribe({
                it.forEach {
                    println("${it.title}")
                }
            })
}
