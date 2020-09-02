package me.tokornoe.gads_leaderboardapp.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import me.tokornoe.gads_leaderboardapp.model.LearningHoursDataModel
import me.tokornoe.gads_leaderboardapp.model.LearningIQDataModel
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = " https://gadsapi.herokuapp.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface LeaderBoardApiService {
    @GET("api/hours")
     fun getHours():
           Deferred<List<LearningHoursDataModel>>

    @GET("api/SkillIq")
        fun getSkillIq():
            Deferred<List<LearningIQDataModel>>
}

object LeaderBoardApi {
    val retrofitService: LeaderBoardApiService by lazy {
        retrofit.create(LeaderBoardApiService::class.java)
    }
}
