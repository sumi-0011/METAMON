package com.andes.metamon

import android.app.Application
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkLossHandler
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility
import com.amazonaws.regions.Region
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3Client
import com.andes.metamon.logging.Logger
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MetamonApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initLogger()
        initAmazonS3()
    }

    private fun initLogger() {
        Logger.init()
    }

    private fun initAmazonS3() {
        val awsCredentials =
            BasicAWSCredentials(BuildConfig.AWS_ACCESS_KEY, BuildConfig.AWS_SECRET_KEY)
        s3Client = AmazonS3Client(awsCredentials, Region.getRegion(Regions.AP_NORTHEAST_2))
        transferUtility =
            TransferUtility.builder().s3Client(s3Client).context(applicationContext).build()
        TransferNetworkLossHandler.getInstance(applicationContext)
    }

    companion object {
        lateinit var s3Client: AmazonS3Client
        lateinit var transferUtility: TransferUtility
    }
}