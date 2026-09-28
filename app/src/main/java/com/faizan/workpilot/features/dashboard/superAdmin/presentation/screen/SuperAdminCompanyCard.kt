package com.faizan.workpilot.features.dashboard.superAdmin.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.faizan.workpilot.core.ui.theme.dimens
import com.faizan.workpilot.features.dashboard.superAdmin.domain.model.SuperAdminCompany

@Composable
fun SuperAdminCompanyCard(
    company: SuperAdminCompany,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        shape = RoundedCornerShape(
            MaterialTheme.dimens.radiusM
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = MaterialTheme.dimens.spaceM,
                    vertical = MaterialTheme.dimens.spaceS
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            if (company.logoUrl != null) {
                AsyncImage(
                    model = company.logoUrl,
                    contentDescription = company.name,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            } else {
                CompanyLogoPlaceholder()
            }

            Spacer(
                modifier = Modifier.width(
                    MaterialTheme.dimens.spaceM
                )
            )

            androidx.compose.foundation.layout.Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(
                    MaterialTheme.dimens.spaceXS
                )
            ) {
                Text(
                    text = company.name,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = if (company.active) {
                        "Active"
                    } else {
                        "Inactive"
                    },
                    color = if (company.active) {
                        Color(0xFF2E7D32)
                    } else {
                        Color(0xFFC62828)
                    },
                    style = MaterialTheme.typography.labelMedium
                )
            }

            Icon(
                imageVector = Icons.Default.ArrowForwardIos,
                contentDescription = "Open company",
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
private fun CompanyLogoPlaceholder() {
    androidx.compose.foundation.layout.Box(
        modifier = Modifier
            .size(48.dp)
            .clip(CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "C",
            style = MaterialTheme.typography.titleMedium
        )
    }
}