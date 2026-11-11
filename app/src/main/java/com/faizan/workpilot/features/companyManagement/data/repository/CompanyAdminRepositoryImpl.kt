package com.faizan.workpilot.features.companyManagement.data.repository

import com.faizan.workpilot.features.companyManagement.data.api.CompanyManagementApi
import com.faizan.workpilot.features.companyManagement.data.mapper.toDomain
import com.faizan.workpilot.features.companyManagement.data.model.admin.CreateCompanyAdminRequestDto
import com.faizan.workpilot.features.companyManagement.data.model.admin.UpdateAdminStatusRequestDto
import com.faizan.workpilot.features.companyManagement.data.model.admin.UpdateCompanyAdminRequestDto
import com.faizan.workpilot.features.companyManagement.domain.model.admin.CompanyAdmin
import com.faizan.workpilot.features.companyManagement.domain.model.admin.CompanyAdminDetails
import com.faizan.workpilot.features.companyManagement.domain.model.admin.CompanyAdminPage
import com.faizan.workpilot.features.companyManagement.domain.model.admin.CompanyAdminUpdateResult
import com.faizan.workpilot.features.companyManagement.domain.repository.CompanyAdminRepository
import javax.inject.Inject

class CompanyAdminRepositoryImpl @Inject constructor(
    private val api: CompanyManagementApi
) : CompanyAdminRepository {

    // Get Admin List
    override suspend fun getCompanyAdmins(
        companyId: Long,
        page: Int,
        size: Int,
        search: String?
    ): CompanyAdminPage {
        return api.getCompanyAdmins(
            companyId = companyId,
            page = page,
            size = size,
            search = search
        ).toDomain()
    }

    // Create Admin
    override suspend fun createCompanyAdmin(
        companyId: Long,
        firstName: String,
        lastName: String,
        email: String,
        phoneNumber: String,
        password: String
    ): CompanyAdmin {

        val request = CreateCompanyAdminRequestDto(
            firstName = firstName,
            lastName = lastName,
            email = email,
            phoneNumber = phoneNumber,
            password = password
        )

        return api.createCompanyAdmin(
            companyId = companyId,
            request = request
        ).toDomain()
    }

    // Get Admin Details
    override suspend fun getCompanyAdminDetails(
        companyId: Long,
        adminId: Long
    ): CompanyAdminDetails {

        return api.getCompanyAdminDetails(
            companyId = companyId,
            adminId = adminId
        ).toDomain()
    }

    // Activate / Deactivate Admin
    override suspend fun updateCompanyAdminStatus(
        companyId: Long,
        adminId: Long,
        active: Boolean
    ): CompanyAdminDetails {

        val request = UpdateAdminStatusRequestDto(
            active = active
        )

        return api.updateCompanyAdminStatus(
            companyId = companyId,
            adminId = adminId,
            request = request
        ).toDomain()
    }

    // Update Company Admin
    override suspend fun updateCompanyAdmin(
        companyId: Long,
        adminId: Long,
        firstName: String,
        lastName: String,
        phoneNumber: String
    ): CompanyAdminUpdateResult {

        val request = UpdateCompanyAdminRequestDto(
            firstName = firstName,
            lastName = lastName,
            phoneNumber = phoneNumber
        )

        val response = api.updateCompanyAdmin(
            companyId = companyId,
            adminId = adminId,
            request = request
        )

        return CompanyAdminUpdateResult(
            message = response.message,
            admin = response.data.toDomain()
        )
    }

}