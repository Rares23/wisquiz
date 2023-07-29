package com.crxapplications.wisquiz.core.data.repository

import android.content.SharedPreferences
import android.content.res.Resources.NotFoundException
import com.crxapplications.wisquiz.core.data.api.ResponseCode
import com.crxapplications.wisquiz.core.data.api.TokenApiService
import com.crxapplications.wisquiz.core.data.prefs.SharedPreferencesKeys
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

interface TokenRepository {
    suspend fun getToken(): Flow<String>
    suspend fun resetToken(): Flow<String>
}

class TokenRepositoryImpl constructor(
    private val tokenApiService: TokenApiService,
    private val sharedPreferences: SharedPreferences,
) : TokenRepository {
    override suspend fun getToken(): Flow<String> = flow {
        val cachedToken = sharedPreferences.getString(SharedPreferencesKeys.SESSION_TOKEN, null)
        if (cachedToken == null) {
            tokenApiService.fetchSessionToken().collect { data ->
                if (data.responseCode == ResponseCode.SUCCESS) {
                    val token = data.token
                    sharedPreferences
                        .edit()
                        .putString(SharedPreferencesKeys.SESSION_TOKEN, token)
                        .apply()
                    emit(token)
                }

                //TODO: What happen when there is an error and we don't have a token?
            }
        } else {
            emit(cachedToken)
        }
    }

    override suspend fun resetToken(): Flow<String> {
        TODO("Not yet implemented")
    }

}