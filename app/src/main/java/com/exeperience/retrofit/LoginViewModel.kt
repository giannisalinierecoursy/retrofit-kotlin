package com.exeperience.retrofit

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginViewModel: ViewModel() {
    fun makeRequest() {
        val retrofitInstance = RetrofitClient.getInstance()
        val loginService = retrofitInstance.create(UserService::class.java)
        //val loginService = RetrofitClient.getUserServiceLogin()
        val loginRequest = LoginRequest("fergus.bray@protonmail.com", "Azerty123*")

        Log.d("api", "body: $loginRequest")
        val loginCall = loginService.userLogin(loginRequest)

        loginCall.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    Log.d("api", "tout c'est bien passé")
                } else {
                    Log.d("api", "tout c'est bien passé NOOOPE")

                }
            }
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.d("api", "${t.message}")
                Log.d("api", "Quentin + Tranco = <3")
            }
        })
    }

}