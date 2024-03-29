package com.example.phone_app.Network

import com.example.phone_app.Data.Orders
import com.example.phone_app.Data.OrdersByname
import com.example.phone_app.Data.tables
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//const val BASE_URLtables1 = "https://rectifiable-merchan.000webhostapp.com/"

interface OrderApi{

    @GET("ShowOrder.php")
    fun getOrders() : Deferred<List<Orders>>

    @GET("ShowTodayOrders.php")
    fun getDaily() : Deferred<List<Orders>>

    @GET("ShowTodayOrders.php")
    fun getWeek() : Deferred<List<Orders>>

    @GET("ShowMonthOrders.php")
    fun getMonth() : Deferred<List<Orders>>

    @GET("ShowYearOrders.php")
    fun getYear() : Deferred<List<Orders>>

    @GET("OrderBynameDateYear.php")
    fun getYearByname(@Query("UserName") name: String) : Deferred<List<OrdersByname>>
    @GET("OrderBynameDateMonth.php")
    fun getWeekByname(@Query("UserName")  name: String) : Deferred<List<OrdersByname>>
    @GET("OrderBynameDateMonth.php")
    fun getMonthByname(@Query("UserName") name: String) : Deferred<List<OrdersByname>>
    @GET("OrderBynameDateDay.php")
    fun getDailyByname(@Query("UserName") name: String) : Deferred<List<OrdersByname>>

    companion object {
        operator fun invoke(
            connectivityInterceptor: ConnectivityInterceptor
        ) : OrderApi {
            val okHttpClient = OkHttpClient.Builder().addInterceptor(connectivityInterceptor).build()

            return Retrofit.Builder().client(okHttpClient)
                .baseUrl(BASE_URLtables).addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(OrderApi::class.java)


        }
    }
}