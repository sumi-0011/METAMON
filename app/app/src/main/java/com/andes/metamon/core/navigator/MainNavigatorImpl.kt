package com.andes.metamon.core.navigator

import android.content.Context
import com.andes.metamon.auth.presentation.AuthActivity
import com.andes.metamon.main.MainActivity
import com.andes.metamon.utils.navigateActivity
import com.andes.navigator.MainNavigator
import javax.inject.Inject

internal class MainNavigatorImpl @Inject constructor() : MainNavigator {
    override fun navigateMain(context: Context) {
        context.navigateActivity<MainActivity>()
    }

    override fun navigateAuth(context: Context) {
        context.navigateActivity<AuthActivity>()
    }

    override fun navigatePost(context: Context) {
        // TODO 포스트 화면 이동
    }

    override fun transactionToHome() {
        MainActivity.transactionToHome()
    }
}