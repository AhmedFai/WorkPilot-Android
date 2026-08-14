package com.faizan.workpilot.core.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.tokenDataStore by preferencesDataStore(
    name = "token_preferences"
)

class TokenStorage(
    private val context: Context
) {

    private companion object {
        val ACCESS_TOKEN =
            stringPreferencesKey("access_token")

        val REFRESH_TOKEN =
            stringPreferencesKey("refresh_token")
    }

    @Volatile
    private var cachedAccessToken: String? = null

    val accessToken: Flow<String?> =
        context.tokenDataStore.data.map { preferences ->
            preferences[ACCESS_TOKEN]
        }

    val refreshToken: Flow<String?> =
        context.tokenDataStore.data.map { preferences ->
            preferences[REFRESH_TOKEN]
        }

    fun getAccessToken(): String? {
        return cachedAccessToken
    }

    suspend fun saveTokens(
        accessToken: String,
        refreshToken: String
    ) {
        cachedAccessToken = accessToken

        context.tokenDataStore.edit { preferences ->
            preferences[ACCESS_TOKEN] = accessToken
            preferences[REFRESH_TOKEN] = refreshToken
        }
    }

    suspend fun updateAccessToken(
        accessToken: String
    ) {
        cachedAccessToken = accessToken

        context.tokenDataStore.edit { preferences ->
            preferences[ACCESS_TOKEN] = accessToken
        }
    }

    suspend fun clearTokens() {
        cachedAccessToken = null

        context.tokenDataStore.edit { preferences ->
            preferences.remove(ACCESS_TOKEN)
            preferences.remove(REFRESH_TOKEN)
        }
    }
}