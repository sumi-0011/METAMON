package com.andes.metamon.auth.presentation

import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import androidx.activity.viewModels
import com.andes.metamon.R
import com.andes.metamon.auth.presentation.login.AutoLoginConstant
import com.andes.metamon.auth.presentation.login.LoginFragment
import com.andes.metamon.auth.presentation.login.LoginViewModel
import com.andes.metamon.databinding.ActivityAuthBinding
import com.andes.metamon.utils.BindingActivity
import com.andes.metamon.utils.replace
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity : BindingActivity<ActivityAuthBinding>(R.layout.activity_auth) {
    private val loginViewModel by viewModels<LoginViewModel>()
    lateinit var autoLoginState: AutoLoginConstant

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkAutoLoginState()
        autoLogin()
    }

    private fun autoLogin() {
        val content: View = findViewById(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    return if (::autoLoginState.isInitialized) {
                        if (autoLoginState == AutoLoginConstant.AUTO_LOGIN_SUCCESS) {
                            mainNavigator.navigateMain(this@AuthActivity)
                            finish()
                        } else {
                            replace<LoginFragment>(R.id.container_auth)
                        }
                        content.viewTreeObserver.removeOnPreDrawListener(this)
                        true
                    } else {
                        false
                    }
                }
            }
        )
    }

    private fun checkAutoLoginState() {
        autoLoginState = if (loginViewModel.getAccessToken() != "") {
            AutoLoginConstant.AUTO_LOGIN_SUCCESS
        } else {
            AutoLoginConstant.AUTO_LOGIN_FAILURE
        }
    }
}