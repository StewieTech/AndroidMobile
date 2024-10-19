package com.example.asklolalingo.domain.remote

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object NetworkModule {

    private const val BASE_URL = "https://api.openai.com/"

    fun provideOpenAIService(apikey: String): OpenAIService {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(ApiKeyInterceptor(apikey))
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonconverterFactory.create())
    }

    private class ApiKeyInterceptor(private val apikey: String) : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer $apikey")
                .build()
            return chain.proceed(request) ;
        }
    }
}
