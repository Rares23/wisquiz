package com.crxapplications.wisquiz.core.data.repository

import android.content.SharedPreferences
import com.crxapplications.wisquiz.core.data.api.ResponseCode
import com.crxapplications.wisquiz.core.data.api.TokenApiService
import com.crxapplications.wisquiz.core.data.entity.SessionResponseDto
import com.crxapplications.wisquiz.core.data.prefs.SharedPreferencesKeys
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.Assert.*
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.any
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.anyOrNull
import org.mockito.kotlin.eq
import org.mockito.kotlin.times

@RunWith(MockitoJUnitRunner::class)
class TokenRepositoryImplTest {

    private val tokenApiServiceMock: TokenApiService = Mockito.mock(TokenApiService::class.java)

    private val sharedPrefsEditorMock: SharedPreferences.Editor =
        Mockito.mock(SharedPreferences.Editor::class.java)

    private val sharedPreferencesMock: SharedPreferences =
        Mockito.mock(SharedPreferences::class.java)

    private lateinit var tokenRepository: TokenRepository

    @Before
    fun setUp() {
        tokenRepository = TokenRepositoryImpl(
            tokenApiService = tokenApiServiceMock,
            sharedPreferences = sharedPreferencesMock
        )
    }

    @Test
    fun getToken_CachedToken_WhenExistsInSharedPrefs() = runTest {
        val expectedToken = "ASDF"

        `when`(
            sharedPreferencesMock.getString(
                eq(SharedPreferencesKeys.SESSION_TOKEN),
                anyOrNull()
            )
        ).thenReturn(expectedToken)


        var actual: String? = null

        tokenRepository.getToken().collect {
            actual = it
        }

        assertEquals(expectedToken, actual)
    }

    @Test
    fun getToken_NewToken_WhenCachedIsNull() = runTest {
        val expectedToken = "ASDF"

        `when`(
            sharedPreferencesMock.getString(
                eq(SharedPreferencesKeys.SESSION_TOKEN),
                anyOrNull()
            )
        ).thenReturn(null)

        `when`(sharedPreferencesMock.edit()).thenReturn(sharedPrefsEditorMock)

        `when`(
            sharedPrefsEditorMock.putString(
                any(),
                anyOrNull()
            )
        ).thenReturn(sharedPrefsEditorMock)

        `when`(tokenApiServiceMock.fetchSessionToken()).thenAnswer {
            flow {
                emit(
                    SessionResponseDto(
                        responseCode = ResponseCode.SUCCESS,
                        token = expectedToken,
                        responseMessage = "Success message"
                    )
                )
            }
        }

        var actual: String? = null

        tokenRepository.getToken().collect {
            actual = it
        }

        assertEquals(expectedToken, actual)
    }

    @Test
    fun getToken_SaveTokenInSharedPrefs_WhenNewTokenIsFetched() = runTest {
        val newToken = "ASDF"

        `when`(
            sharedPreferencesMock.getString(
                eq(SharedPreferencesKeys.SESSION_TOKEN),
                anyOrNull()
            )
        ).thenReturn(null)

        `when`(tokenApiServiceMock.fetchSessionToken()).thenAnswer {
            flow {
                emit(
                    SessionResponseDto(
                        responseCode = ResponseCode.SUCCESS,
                        token = newToken,
                        responseMessage = "Success message"
                    )
                )
            }
        }

        `when`(sharedPreferencesMock.edit()).thenReturn(sharedPrefsEditorMock)

        `when`(
            sharedPrefsEditorMock.putString(
                any(),
                anyOrNull()
            )
        ).thenReturn(sharedPrefsEditorMock)

        tokenRepository.getToken().collect()

        verify(sharedPrefsEditorMock).putString(
            SharedPreferencesKeys.SESSION_TOKEN,
            newToken
        )
    }
}