package com.faizan.workpilot.features.companyManagement.presentation.screen.companyInfo.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.faizan.workpilot.core.ui.theme.dimens
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import com.faizan.workpilot.features.companyManagement.presentation.screen.components.CompanyInfoIconStyle

@Composable
fun CompanyInfoDetailRow(
    icon: ImageVector,
    label: String,
    value: String?,
    iconStyle: CompanyInfoIconStyle,
    showDivider: Boolean = true
) {
    val dimens = MaterialTheme.dimens

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = dimens.spaceM,
                    vertical = dimens.spaceS
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(dimens.iconL),
                shape = RoundedCornerShape(dimens.radiusS),
                color = iconStyle.containerColor
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint =  iconStyle.iconColor,
                    modifier = Modifier
                        .padding(dimens.spaceXS)
                        .fillMaxSize()
                )
            }

            Spacer(
                modifier = Modifier.width(dimens.spaceS)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = label,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Text(
                    text = value.orEmpty(),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(
                        top = dimens.space2XS
                    )
                )
            }
        }

        if (showDivider) {
            HorizontalDivider(
                modifier = Modifier.padding(
                    horizontal = dimens.spaceM
                )
            )
        }
    }
}