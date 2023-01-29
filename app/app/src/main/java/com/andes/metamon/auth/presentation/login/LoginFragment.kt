package com.andes.metamon.auth.presentation.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.andes.metamon.R
import com.andes.metamon.databinding.FragmentLoginBinding
import com.andes.metamon.utils.BindingFragment
import com.andes.metamon.utils.EventObserver
import com.andes.metamon.utils.shortToast

class LoginFragment : BindingFragment<FragmentLoginBinding>(R.layout.fragment_login) {
    private val loginViewModel by activityViewModels<LoginViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }

    private fun initObservers() {
        initMoveToHomeObserver()
        initLoginFailureMessageObserver()
        setupUI()
    }

    private fun setupUI() {
        binding.apply {
            btnNext.setOnClickListener {
                loginViewModel.postLogin(
                    email = etEmail.text.toString(),
                    password = etPassword.text.toString()
                )
            }
        }
    }

    private fun initMoveToHomeObserver() {
        loginViewModel.navigateToHome.observe(
            viewLifecycleOwner,
            EventObserver {
                navigateMainActivity()
            }
        )
    }

    private fun navigateMainActivity() {
        mainNavigator.navigateMain(requireActivity())
        requireActivity().finish()
    }

    private fun initLoginFailureMessageObserver() {
        loginViewModel.loginFailureMessage.observe(viewLifecycleOwner) {
            requireContext().shortToast(getString(R.string.error_login_message))
            clearAllText()
        }
    }

    private fun clearAllText() {
        binding.apply {
            etEmail.text = null
            etPassword.text = null
            etEmail.requestFocus()
        }
    }
}