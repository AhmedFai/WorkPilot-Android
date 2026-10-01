package com.faizan.workpilot.features.companyManagement.domain.repository

import com.faizan.workpilot.features.companyManagement.domain.model.admin.CompanyAdminPage

interface CompanyAdminRepository {

    suspend fun getCompanyAdmins(
        companyId: Long,
        page: Int,
        size: Int,
        search: String? = null
    ): CompanyAdminPage
}