package com.faizan.workpilot.features.companyManagement.presentation.screen.companyStatus.components

import android.view.Gravity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.PowerSettingsNew
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogWindowProvider
import com.faizan.workpilot.R

@Composable
fun CompanyStatusConfirmationDialog(
    companyName: String,
    isActive: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    val actionColor = if (isActive) {
        Color(0xFFEF1D1D)
    } else {
        Color(0xFF16A34A)
    }

    val iconBackgroundColor = if (isActive) {
        Color(0xFFFFE1E1)
    } else {
        Color(0xFFDDF7E8)
    }

    val density = LocalDensity.current
    val view = LocalView.current

    Dialog(
        onDismissRequest = onDismiss
    ) {

        SideEffect {
            val dialogWindowProvider =
                view.parent as? DialogWindowProvider

            dialogWindowProvider?.window?.let { window ->

                window.setGravity(Gravity.CENTER)

                val layoutParams = window.attributes

                layoutParams.y = with(density) {
                    48.dp.roundToPx()
                }

                window.attributes = layoutParams
            }
        }

        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            color = Color(0xFFF9F7FF)
        ) {

            androidx.compose.foundation.layout.Column(
                modifier = Modifier.padding(
                    horizontal = 20.dp,
                    vertical = 16.dp
                ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Surface(
                    modifier = Modifier.size(44.dp),
                    shape = CircleShape,
                    color = iconBackgroundColor
                ) {
                    Icon(
                        imageVector = if (isActive) {
                            Icons.Default.Delete
                        } else {
                            Icons.Default.PowerSettingsNew
                        },
                        contentDescription = null,
                        tint = actionColor,
                        modifier = Modifier.padding(11.dp)
                    )
                }

                Text(
                    text = stringResource(
                        if (isActive) {
                            R.string.company_status_deactivate_title
                        } else {
                            R.string.company_status_activate_title
                        }
                    ),
                    modifier = Modifier.padding(top = 14.dp),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = stringResource(
                        if (isActive) {
                            R.string.company_status_deactivate_message
                        } else {
                            R.string.company_status_activate_message
                        },
                        companyName
                    ),
                    modifier = Modifier.padding(
                        top = 12.dp,
                        bottom = 16.dp
                    ),
                    textAlign = TextAlign.Center
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    OutlinedButton(
                        onClick = onDismiss,
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = stringResource(
                                R.string.company_status_cancel
                            )
                        )
                    }

                    Button(
                        onClick = onConfirm,
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = actionColor
                        )
                    ) {
                        Text(
                            text = stringResource(
                                if (isActive) {
                                    R.string.company_status_deactivate_action
                                } else {
                                    R.string.company_status_activate_action
                                }
                            )
                        )
                    }
                }
            }
        }
    }
}