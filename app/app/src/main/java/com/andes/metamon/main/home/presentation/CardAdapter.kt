package com.andes.metamon.main.home.presentation

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.andes.metamon.R
import com.andes.metamon.databinding.ItemIdCardBinding
import com.andes.metamon.main.home.domain.model.response.UserCardInfo
import com.andes.metamon.utils.ItemDiffCallback
import com.andes.metamon.utils.setOnSingleClickListener
import com.bumptech.glide.Glide

class CardAdapter(
    private val onCardClick: () -> Unit
) : ListAdapter<UserCardInfo, CardAdapter.CardViewHolder>(
    ItemDiffCallback<UserCardInfo>(
        onContentsTheSame = { oldItem, newItem -> oldItem.hashCode() == newItem.hashCode() },
        onItemsTheSame = { oldItem, newItem -> oldItem.userId == newItem.userId }
    )
) {
    private lateinit var inflater: LayoutInflater

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        if (!::inflater.isInitialized)
            inflater = LayoutInflater.from(parent.context)
        val binding = ItemIdCardBinding.inflate(inflater, parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.onBind(getItem(position), onCardClick)
    }

    class CardViewHolder(private val binding: ItemIdCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(
            userCardInfo: UserCardInfo,
            onCardClick: () -> Unit
        ) {
            binding.apply {
                tvNickname.text = userCardInfo.nickname + "님의"
                tvIdCard.text = userCardInfo.platform + "신분증"
                tvUsername.text = userCardInfo.userName
                tvTagUsername.text = "@${userCardInfo.nickname}"
                Glide.with(itemView)
                    .load(userCardInfo.qrImageUrl)
                    .centerCrop()
                    .into(binding.ivQrImage)
                Glide.with(itemView)
                    .load(userCardInfo.qrImageUrl)
                    .centerCrop()
                    .into(binding.ivQrImageMetamon)
                tvEmailMetamon.text = userCardInfo.userEmail
                tvDateMetamon.text = userCardInfo.userBirth
            }
            var isMetamonClicked: Boolean = false
            var isZepetoClicked: Boolean = false
            var isRobloxClicked: Boolean = false
            // 카드 플랫폼
            binding.apply {
                if (userCardInfo.platform == "ZEPETO") {
                    ivPlatform.setBackgroundResource(R.drawable.img_zepeto)
                    Glide.with(itemView)
                        .load(userCardInfo.profileImageUrl)
                        .override(250, 250)
                        .into(binding.ivImage)
                    clMetamon.visibility = View.GONE
                    clMore.visibility = View.GONE
                    clDetail.visibility = View.GONE
                    clMetamonDetail.visibility = View.GONE
                    root.setOnSingleClickListener {
                        if (isZepetoClicked) {
                            ivImage.setColorFilter(
                                Color.rgb(255, 255, 255),
                                android.graphics.PorterDuff.Mode.MULTIPLY
                            )
                            clDetail.visibility = View.GONE
                        } else {
                            ivImage.setColorFilter(
                                Color.rgb(123, 123, 123),
                                android.graphics.PorterDuff.Mode.MULTIPLY
                            )
                            clDetail.visibility = View.VISIBLE
                        }
                        isZepetoClicked = !isZepetoClicked
                    }
                } else if (userCardInfo.platform == "ROBLOX") {
                    ivPlatform.setBackgroundResource(R.drawable.img_roblox)
                    Glide.with(itemView)
                        .load(userCardInfo.profileImageUrl)
                        .into(binding.ivImage)
                    clMetamon.visibility = View.GONE
                    clMore.visibility = View.GONE
                    clDetail.visibility = View.GONE
                    clMetamonDetail.visibility = View.GONE
                    root.setOnSingleClickListener {
                        if (isRobloxClicked) {
                            ivImage.setColorFilter(
                                Color.rgb(255, 255, 255),
                                android.graphics.PorterDuff.Mode.MULTIPLY
                            )
                            clDetail.visibility = View.GONE
                        } else {
                            ivImage.setColorFilter(
                                Color.rgb(123, 123, 123),
                                android.graphics.PorterDuff.Mode.MULTIPLY
                            )
                            clDetail.visibility = View.VISIBLE
                        }
                        isRobloxClicked = !isRobloxClicked
                    }
                } else if (userCardInfo.platform == "MORE") {
                    ivImage.setBackgroundResource(R.color.gray_3)
                    clMetamon.visibility = View.GONE
                    clDetail.visibility = View.GONE
                    clMetamonDetail.visibility = View.GONE
                    root.setOnClickListener {
                        onCardClick()
                    }
                } else { // 메타몽
                    ivPlatform.setBackgroundResource(R.drawable.img_metamon)
                    ivImage.setBackgroundResource(R.color.blue)
                    clMetamon.visibility = View.VISIBLE
                    clMore.visibility = View.GONE
                    clDetail.visibility = View.GONE
                    clMetamonDetail.visibility = View.GONE
                    root.setOnClickListener {
                        if (isMetamonClicked) {
                            clMetamon.visibility = View.VISIBLE
                            clMetamonDetail.visibility = View.GONE
                        } else {
                            clMetamon.visibility = View.GONE
                            clMetamonDetail.visibility = View.VISIBLE
                        }
                        isMetamonClicked = !isMetamonClicked
                    }
                }
            }


        }
    }
}