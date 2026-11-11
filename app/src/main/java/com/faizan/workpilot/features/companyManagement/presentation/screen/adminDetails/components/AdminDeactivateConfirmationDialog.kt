
package com.faizan.workpilot.features.companyManagement.presentation.screen.adminDetails.components

import android.view.Gravity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogWindowProvider
import com.faizan.workpilot.R
import com.faizan.workpilot.core.ui.theme.dimens

@Composable
fun AdminDeactivateConfirmationDialog(
    adminName: String,
    isActive: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    val dimens = MaterialTheme.dimens

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

    Dialog(onDismissRequest = onDismiss) {
        SideEffect {
            val provider = view.parent as? DialogWindowProvider

            provider?.window?.let { window ->
                window.setGravity(Gravity.CENTER)

                val params = window.attributes
                params.y = with(density) {
                    dimens.space2XL.roundToPx()
                }
                window.attributes = params
            }
        }

        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(dimens.radiusXL),
            color = Color(0xFFF9F7FF)
        ) {
            Column(
                modifier = Modifier.padding(
                    horizontal = dimens.spaceL,
                    vertical = dimens.spaceM
                ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Surface(
                    modifier = Modifier.size(dimens.avatarS),
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
                        modifier = Modifier.padding(dimens.spaceS)
                    )
                }

                Text(
                    text = stringResource(
                        if (isActive) {
                            R.string.admin_deactivate_confirmation_title
                        } else {
                            R.string.admin_activate_confirmation_title
                        }
                    ),
                    modifier = Modifier.padding(top = dimens.spaceS),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = stringResource(
                        if (isActive) {
                            R.string.admin_deactivate_confirmation_message
                        } else {
                            R.string.admin_activate_confirmation_message
                        },
                        adminName
                    ),
                    modifier = Modifier.padding(
                        top = dimens.spaceS,
                        bottom = dimens.spaceM
                    ),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(dimens.spaceXS)
                ) {
                    OutlinedButton(
                        onClick = onDismiss,
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(dimens.radiusS)
                    ) {
                        Text(stringResource(R.string.company_status_cancel))
                    }

                    Button(
                        onClick = onConfirm,
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(dimens.radiusS),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = actionColor
                        )
                    ) {
                        Text(
                            stringResource(
                                if (isActive) {
                                    R.string.admin_deactivate
                                } else {
                                    R.string.admin_activate
                                }
                            )
                        )
                    }
                }
            }
        }
    }
}
