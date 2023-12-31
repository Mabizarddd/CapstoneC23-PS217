package com.esa.submission1bpaai.data.network.api

import com.esa.submission1bpaai.data.network.response.BaseResponse
import com.esa.submission1bpaai.data.network.response.LoginResponse
import com.esa.submission1bpaai.data.network.response.StoryResponse
import com.esa.submission1bpaai.data.request.LoginRequest
import com.esa.submission1bpaai.data.request.RegisterRequest
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @POST("users")
    fun register(
        @Body request: RegisterRequest
    ): Call<BaseResponse>

    @POST("login")
    fun login(
        @Body request: LoginRequest
    ): Call<LoginResponse>

    @GET("stories")
    fun getStories(
        @Header("Authorization") token: String,
    ): Call<StoryResponse>

    @Multipart
    @POST("stories")
    fun addStory(
        @Header("Authorization") token: String,
        @Part file: MultipartBody.Part,
        @Part("description") description: RequestBody,
    ): Call<BaseResponse>


}