package com.andes.navigator

import android.content.Context
import android.content.Intent

interface MainNavigator {
    fun navigateMain(context: Context)
    fun navigateAuth(context: Context)
    fun navigatePost(context: Context)
    /** MainActivity로 이동시 home화면이 나오도록 transaction 하는 로직 */
    fun transactionToHome()
}
