package com.exeperience.retrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {
    @POST("auth/signin")
    fun userLogin(@Body loginRequest: LoginRequest): Call<LoginResponse>
}