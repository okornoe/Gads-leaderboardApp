package me.tokornoe.gads_leaderboardapp.googleforms

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

private const val GOOGLE_FORMS_BASE_URL = "https://docs.google.com/forms/d/e/"
private const val GOOGLE_FORM_VALUE = "1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse"

private const val MOCK_GOOGLE_FORMS_BASE_URL = "" //replace with your own test url
private const val MOCK_GOOGLE_FORM_VALUE = "" // replace with your owr test value

private val retrofit = Retrofit.Builder()
    .baseUrl(MOCK_GOOGLE_FORMS_BASE_URL)
    .build()

//mock fields, should be replaced by test fields
//first create a google forms and get the fields id for your testing
//before replacing it with the actual fields

 interface GoogleFormsApiService {
    @POST(MOCK_GOOGLE_FORM_VALUE)
    @FormUrlEncoded
    fun  postValues(
        @Field("entry.2142461976") firstName: String,
        @Field("entry.243759480") lastName: String,
        @Field("entry.1254919597") email: String,
        @Field("entry.862272373") projectLinkToGithub: String,
        ): Call<Void>
}

object GoogleWebFormsService {
    val formsApiService: GoogleFormsApiService by lazy {
        retrofit.create(GoogleFormsApiService::class.java)
    }
}
