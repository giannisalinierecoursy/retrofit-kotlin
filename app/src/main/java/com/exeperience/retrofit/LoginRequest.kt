package com.exeperience.retrofit

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("username")
    val userEmail: String,
    @SerializedName("password")
    val userPassword: String
)