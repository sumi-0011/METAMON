package com.andes.metamon.main.profile.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.andes.metamon.R
import com.andes.metamon.databinding.FragmentProfileBinding
import com.andes.metamon.main.home.domain.model.response.UserCardInfo
import com.andes.metamon.main.home.presentation.HomeFragment
import com.andes.metamon.main.home.presentation.HomeViewModel
import com.andes.metamon.utils.BindingFragment
import com.andes.metamon.utils.UiState
import com.andes.metamon.utils.setOnSingleClickListener
import com.andes.metamon.utils.shortToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class ProfileFragment : BindingFragment<FragmentProfileBinding>(R.layout.fragment_profile) {
    private val profileViewModel: ProfileViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        profileViewModel.getProfile()
        initObservers()
    }

    private fun setupUI() {
        binding.clSeeAll.setOnSingleClickListener {
//            findNavController().navigate()
        }
    }

    private fun initObservers() {
        profileViewModel.homeUiState.flowWithLifecycle(viewLifecycleOwner.lifecycle).onEach {
            when (it) {
                is UiState.Success -> {
                    binding.tvNickname.text = it.data.userName
                    binding.tvToken.text = it.data.userEmail
                }
                is UiState.Failure -> {
                    it.msg?.let { msg ->
                        requireContext().shortToast(msg)
                    }
                }
                else -> {
                    // TODO : 로딩 로직
                }
            }
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }
}