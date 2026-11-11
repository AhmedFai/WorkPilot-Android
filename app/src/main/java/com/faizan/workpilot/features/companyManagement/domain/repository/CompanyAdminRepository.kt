package com.faizan.workpilot.features.companyManagement.domain.repository

import com.faizan.workpilot.features.companyManagement.domain.model.admin.CompanyAdmin
import com.faizan.workpilot.features.companyManagement.domain.model.admin.CompanyAdminDetails
import com.faizan.workpilot.features.companyManagement.domain.model.admin.CompanyAdminPage
import com.faizan.workpilot.features.companyManagement.domain.model.admin.CompanyAdminUpdateResult

interface CompanyAdminRepository {

    // Get Admin List
    suspend fun getCompanyAdmins(
        companyId: Long,
        page: Int,
        size: Int,
        search: String? = null
    ): CompanyAdminPage

    // Create Admin
    suspend fun createCompanyAdmin(
        companyId: Long,
        firstName: String,
        lastName: String,
        email: String,
        phoneNumber: String,
        password: String
    ): CompanyAdmin

    // Get Admin Details
    suspend fun getCompanyAdminDetails(
        companyId: Long,
        adminId: Long
    ): CompanyAdminDetails

    // Update Admin Status
    suspend fun updateCompanyAdminStatus(
        companyId: Long,
        adminId: Long,
        active: Boolean
    ): CompanyAdminDetails

    // Update Admin
    suspend fun updateCompanyAdmin(
        companyId: Long,
        adminId: Long,
        firstName: String,
        lastName: String,
        phoneNumber: String
    ): CompanyAdminUpdateResult
}