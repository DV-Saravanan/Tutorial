package com.sarna.tutorial.retrofit

import android.content.Context
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroWebservice(myContext: Context) {
    private val thisContext: Context = myContext
    fun invokeWebservice(
        mReq: String,
        mURL: String,
        mInterface: WebserviceInterface
    ) {
        var retrofit = Retrofit.Builder()
            .baseUrl("https://simplifiedcoding.net/demos/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        val api = retrofit.create(superheroAPI::class.java)

        api.getHeroes()?.enqueue(object : Callback<List<Heros?>?> {
            override fun onResponse(call: Call<List<Heros?>?>?, response: Response<List<Heros?>?>) {
                mInterface.onWebserviceSuccess(response.toString())
            }

            override fun onFailure(call: Call<List<Heros?>?>?, t: Throwable) {
                mInterface.onWebserviceFail(t.message.toString())
            }
        })
    }
}