package com.crxapplications.wisquiz.flows.quiz.data.provider

import retrofit2.http.GET
import retrofit2.http.Query

interface QuizApiService {
    @GET
    fun fetchQuizzes(@Query("category") categoryId: Int, @Query("token") token: String)
}