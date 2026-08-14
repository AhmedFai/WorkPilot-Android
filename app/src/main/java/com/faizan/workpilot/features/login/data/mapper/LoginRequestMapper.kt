package com.faizan.workpilot.features.login.data.mapper

import com.faizan.workpilot.features.login.data.model.LoginRequestDto
import com.faizan.workpilot.features.login.domain.model.LoginRequest

fun LoginRequest.toDto(): LoginRequestDto {
    return LoginRequestDto(
        email = email,
        password = password
    )
}