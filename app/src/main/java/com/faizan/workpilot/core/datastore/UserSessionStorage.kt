package com.faizan.workpilot.core.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.faizan.workpilot.features.login.domain.model.UserSession
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.userSessionDataStore by preferencesDataStore(
    name = "user_session_preferences"
)

class UserSessionStorage(
    private val context: Context
) {

    private companion object {
        val USER_ID = longPreferencesKey("user_id")
        val FIRST_NAME = stringPreferencesKey("first_name")
        val LAST_NAME = stringPreferencesKey("last_name")
        val EMAIL = stringPreferencesKey("email")
        val ROLE = stringPreferencesKey("role")
    }

    val userSession: Flow<UserSession?> =
        context.userSessionDataStore.data.map { preferences ->

            val id = preferences[USER_ID]
                ?: return@map null

            UserSession(
                id = id,
                firstName = preferences[FIRST_NAME].orEmpty(),
                lastName = preferences[LAST_NAME].orEmpty(),
                email = preferences[EMAIL].orEmpty(),
                role = preferences[ROLE].orEmpty()
            )
        }

    suspend fun saveUserSession(
        user: UserSession
    ) {
        context.userSessionDataStore.edit { preferences ->

            preferences[USER_ID] = user.id
            preferences[FIRST_NAME] = user.firstName
            preferences[LAST_NAME] = user.lastName
            preferences[EMAIL] = user.email
            preferences[ROLE] = user.role
        }
    }

    suspend fun clearUserSession() {
        context.userSessionDataStore.edit { preferences ->
            preferences.clear()
        }
    }
}