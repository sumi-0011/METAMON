package com.andes.metamon.core.domain.repository

import com.andes.metamon.core.domain.model.CertificateRequest
import java.io.File

interface CertificateRepository {

    suspend fun postCertificate(certificateRequest: CertificateRequest): Result<String>

    suspend fun uploadAndDownloadFile(
        folderName: String,
        userId: Long,
        fileName: String,
        file: File,
        onResult: (String) -> Unit
    )
}