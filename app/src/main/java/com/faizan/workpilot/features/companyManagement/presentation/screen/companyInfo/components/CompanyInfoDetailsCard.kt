package com.faizan.workpilot.features.companyManagement.presentation.screen.companyInfo.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.faizan.workpilot.core.ui.theme.dimens
import com.faizan.workpilot.features.companyManagement.domain.model.companyInfo.CompanyInfo
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.LocationCity
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Public
import androidx.compose.ui.res.stringResource
import com.faizan.workpilot.R
import com.faizan.workpilot.features.companyManagement.presentation.screen.components.CompanyInfoIconColors

@Composable
fun CompanyInfoDetailsCard(
    company: CompanyInfo
) {
    val dimens = MaterialTheme.dimens

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimens.elevationS
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            // Company Name
            CompanyInfoDetailRow(
                icon = Icons.Default.Badge,
                label = stringResource(R.string.company_information_company_name),
                value = company.name,
                iconStyle = CompanyInfoIconColors.companyName
            )

            // Email
            CompanyInfoDetailRow(
                icon = Icons.Default.Email,
                label = stringResource(R.string.company_information_email),
                value = company.email,
                iconStyle = CompanyInfoIconColors.email
            )

            // Phone
            CompanyInfoDetailRow(
                icon = Icons.Default.Phone,
                label = stringResource(R.string.company_information_phone),
                value = company.phone,
                iconStyle = CompanyInfoIconColors.phone
            )

            // Website
            CompanyInfoDetailRow(
                icon = Icons.Default.Language,
                label = stringResource(R.string.company_information_website),
                value = company.website,
                iconStyle = CompanyInfoIconColors.website
            )

            // Address
            CompanyInfoDetailRow(
                icon = Icons.Default.LocationOn,
                label = stringResource(R.string.company_information_address),
                value = buildAddress(
                    company.addressLine1,
                    company.addressLine2
                ),
                iconStyle = CompanyInfoIconColors.address
            )

            // City
            CompanyInfoDetailRow(
                icon = Icons.Default.LocationCity,
                label = stringResource(R.string.company_information_city),
                value = company.city,
                iconStyle = CompanyInfoIconColors.city
            )

            // State
            CompanyInfoDetailRow(
                icon = Icons.Default.Map,
                label = stringResource(R.string.company_information_state),
                value = company.state,
                iconStyle = CompanyInfoIconColors.state
            )

            // Postal Code
            CompanyInfoDetailRow(
                icon = Icons.Default.LocationOn,
                label = stringResource(R.string.company_information_postal_code),
                value = company.postalCode,
                iconStyle = CompanyInfoIconColors.postalCode
            )

            // Country
            CompanyInfoDetailRow(
                icon = Icons.Default.Public,
                label = stringResource(R.string.company_information_country),
                value = company.country,
                iconStyle = CompanyInfoIconColors.country
            )

            // Created At
            CompanyInfoDetailRow(
                icon = Icons.Default.CalendarToday,
                label = stringResource(R.string.company_information_created_at),
                value = formatDateTime(company.createdAt),
                iconStyle = CompanyInfoIconColors.createdAt
            )

            // Updated At
            CompanyInfoDetailRow(
                icon = Icons.Default.AccessTime,
                label = stringResource(R.string.company_information_updated_at),
                value = formatDateTime(company.updatedAt),
                iconStyle = CompanyInfoIconColors.updatedAt,
                showDivider = false
            )
        }
    }
}

private fun buildAddress(
    addressLine1: String?,
    addressLine2: String?
): String? {
    val parts = listOfNotNull(
        addressLine1?.takeIf { it.isNotBlank() },
        addressLine2?.takeIf { it.isNotBlank() }
    )

    return parts
        .takeIf { it.isNotEmpty() }
        ?.joinToString(", ")
}

private fun formatDateTime(value: String): String {
    return try {
        val dateTime = java.time.LocalDateTime.parse(
            value,
            java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME
        )

        dateTime.format(
            java.time.format.DateTimeFormatter.ofPattern(
                "dd MMM yyyy, hh:mm a",
                java.util.Locale.ENGLISH
            )
        )
    } catch (_: Exception) {
        value
    }
}