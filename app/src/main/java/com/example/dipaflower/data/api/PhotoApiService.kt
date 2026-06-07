package com.example.dipaflower.data.api

import com.example.dipaflower.data.model.PhotoModel
import retrofit2.http.GET

interface PhotoApiService {
    @GET("list")
    suspend fun getPhotos(): List<  PhotoModel>
}