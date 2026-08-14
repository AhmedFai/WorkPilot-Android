package com.faizan.workpilot.features.login.data.mapper

import com.faizan.workpilot.features.login.data.model.LoginResponseDto
import com.faizan.workpilot.features.login.domain.model.LoginResult
import com.faizan.workpilot.features.login.domain.model.UserSession

fun LoginResponseDto.toDomain(
    message: String
): LoginResult {

    return LoginResult(
        message = message,
        accessToken = accessToken,
        refreshToken = refreshToken,
        user = UserSession(
            id = user.id,
            firstName = user.firstName,
            lastName = user.lastName,
            email = user.email,
            role = user.role
        )
    )
}
