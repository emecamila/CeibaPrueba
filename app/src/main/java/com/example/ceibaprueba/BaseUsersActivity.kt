package com.example.ceibaprueba

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

open class BaseUsersActivity : AppCompatActivity() {

    fun Context.showAlertToast(
        context: Context = applicationContext,
        message: String?,
        duration: Int = Toast.LENGTH_SHORT
    ) {
        if (message == null) return
        Toast.makeText(context, message, duration).show()
    }



}