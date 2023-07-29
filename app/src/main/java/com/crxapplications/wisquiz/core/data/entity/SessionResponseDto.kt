package com.crxapplications.wisquiz.core.data.entity

import com.squareup.moshi.Json

data class SessionResponseDto(
    @field:Json(name = "response_code") val responseCode: Int,
    @field:Json(name = "response_message") val responseMessage: String,
    @field:Json(name = "token") val token: String,
)