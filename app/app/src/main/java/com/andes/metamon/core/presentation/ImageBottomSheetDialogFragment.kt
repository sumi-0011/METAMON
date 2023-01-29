package com.andes.metamon.core.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.andes.metamon.R
import com.andes.metamon.databinding.FragmentImageBottomSheetDialogBinding
import com.andes.metamon.utils.setOnSingleClickListener
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ImageBottomSheetDialogFragment(
    private val onGalleryClick: () -> Unit,
    private val onCameraClick: () -> Unit
) : BottomSheetDialogFragment() {

    private var _binding: FragmentImageBottomSheetDialogBinding? = null
    val binding: FragmentImageBottomSheetDialogBinding
        get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_image_bottom_sheet_dialog,
                container,
                false
            )
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onTvActionClickListener()
    }

    private fun onTvActionClickListener() {
        binding.ivGallery.setOnSingleClickListener {
            onGalleryClick.invoke()
            dismiss()
        }
        binding.ivCamera.setOnSingleClickListener {
            onCameraClick.invoke()
            dismiss()
        }
    }

    override fun getTheme(): Int = R.style.AppBottomSheetDialogTheme

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}