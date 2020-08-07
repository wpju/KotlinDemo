package com.example.baselibrary.data.net

import com.example.baselibrary.common.Constant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitFactory private constructor(){
    companion object{
        val instance: RetrofitFactory by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED){
            RetrofitFactory()
        }
    }

    private val retrofit : Retrofit
    private val interceptor:Interceptor
    init {
        //通用拦截
        interceptor = Interceptor {
                chain -> val request = chain.request()
            .newBuilder()
            .addHeader("Content_Type","application/json")
            .addHeader("charset","UTF-8")
            .build()

            chain.proceed(request)
        }

        retrofit= Retrofit.Builder()
               .baseUrl(Constant.SERVEL_ADDRESS)
               .addConverterFactory(GsonConverterFactory.create())
               .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).
                client(initClient()).build();
    }

    private fun initClient() : OkHttpClient{
        return OkHttpClient.Builder()
               .addInterceptor(initLogInterceptor())
               .connectTimeout(10,TimeUnit.SECONDS)
               .readTimeout(60,TimeUnit.SECONDS)
               .build()
    }

    private fun initLogInterceptor() : Interceptor {
        val interceptor=HttpLoggingInterceptor()
        interceptor.level=HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    fun <T> create(service : Class<T>):T{
        return retrofit.create(service)
    }
}