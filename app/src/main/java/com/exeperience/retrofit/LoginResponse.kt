package com.exeperience.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("id")
    @Expose
    val id: Double,
    @SerializedName("username")
    @Expose
    val username: String,
    @SerializedName("role")
    @Expose
    val roles: String,
    @SerializedName("acces_token")
    @Expose
    val access_token: String
)
