package com.crxapplications.wisquiz.core.data.api

import com.crxapplications.wisquiz.core.data.entity.SessionResponseDto
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface TokenApiService {
    @GET("?command=request")
    fun fetchSessionToken(): Flow<SessionResponseDto>

    @GET("?command=reset")
    fun resetSessionToken(@Query("token") token: String): Flow<SessionResponseDto>
}