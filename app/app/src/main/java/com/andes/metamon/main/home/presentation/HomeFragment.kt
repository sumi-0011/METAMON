package com.andes.metamon.main.home.presentation

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.andes.metamon.R
import com.andes.metamon.databinding.FragmentHomeBinding
import com.andes.metamon.main.home.domain.model.response.UserCardInfo
import com.andes.metamon.utils.BindingFragment
import com.andes.metamon.utils.UiState
import com.andes.metamon.utils.shortToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlin.math.abs

@AndroidEntryPoint
class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private val homeViewModel: HomeViewModel by activityViewModels()
    private val cardAdapter = CardAdapter(::onCardClick)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvNickname.text = homeViewModel.getUserName()
        setupUI()
        homeViewModel.getCards()
        observeCards()
    }

    private fun setupUI() {
        with(binding.vpIdCard) {
            adapter = cardAdapter
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3
            getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            setViewPagerAnimation(this)
        }
    }

    private fun observeCards() {
        homeViewModel.homeUiState.flowWithLifecycle(viewLifecycleOwner.lifecycle).onEach {
            when (it) {
                is UiState.Success -> {
                    cardAdapter.submitList(
                        it.data + UserCardInfo(
                            authCardId = -1L,
                            nickname = EMPTY_STRING,
                            platform = "MORE",
                            qrImageUrl = EMPTY_STRING,
                            profileImageUrl = EMPTY_STRING,
                            userId = -1L,
                            userName = EMPTY_STRING,
                            userEmail = EMPTY_STRING,
                            userBirth = EMPTY_STRING
                        )
                    )
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

    private fun setViewPagerAnimation(viewPager: ViewPager2) {
        val comPosPageTarn = CompositePageTransformer()
        viewPager.setPadding(150, 0, 150, 0);
        comPosPageTarn.addTransformer(MarginPageTransformer(40))
        comPosPageTarn.addTransformer { page, position ->
            val r: Float = 1 - abs(position)
            page.scaleY = 0.85F + r * 0.15F
        }
        viewPager.setPageTransformer(comPosPageTarn)
    }

    private fun onCardClick() {
        // TODO 카드 넘어가는 로직
    }

    companion object {
        const val EMPTY_STRING = ""
    }
}