package com.exeperience.retrofit

import android.annotation.SuppressLint
import android.app.Activity
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@SuppressLint("StaticFieldLeak")
object RetrofitClient {

    @Volatile
    private var retrofit: Retrofit? = null


    @SuppressLint("StaticFieldLeak")
    @Synchronized
    fun getInstance(): Retrofit{
        retrofit = getRetrofit()
        return retrofit!!

    }

    private fun getRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl("https://api.dev.stocky-agency.fr/api/")
            .client(buildHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
   private  fun buildHttpClient(): OkHttpClient{
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.HEADERS
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val builder = OkHttpClient.Builder().addInterceptor(interceptor)
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
        return builder.build()
   }
    fun getUserServiceLogin(): UserService {
        return getRetrofit().create(UserService::class.java)
    }
}