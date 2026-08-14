package com.faizan.workpilot.core.common.ui.text

import android.content.Context
import androidx.annotation.StringRes

sealed class UiText {

    data class Dynamic(
        val value: String
    ) : UiText()

    data class StringRes(
        @param:androidx.annotation.StringRes
        val resId: Int,
        val args: List<Any> = emptyList()
    ) : UiText()

    fun asString(context: Context): String {
        return when (this) {

            is Dynamic -> {
                value
            }

            is StringRes -> {
                context.getString(
                    resId,
                    *args.toTypedArray()
                )
            }
        }
    }
}