package com.andes.metamon.core.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.andes.metamon.R
import com.andes.metamon.databinding.FragmentMetamonDialogBinding

class MetamonDialogFragment : DialogFragment() {
    private var _binding: FragmentMetamonDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCancelable = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_metamon_dialog, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initCancelButtonListener()
        initCheckButtonListener()
    }

    private fun initView() {
        binding.tvTitle.text = title
        binding.tvContent.text = body
        setLayout()
    }

    private fun setLayout() {
        requireNotNull(dialog).apply {
            requireNotNull(window).apply {
                setLayout(
                    (resources.displayMetrics.widthPixels * 0.91).toInt(),
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                setBackgroundDrawableResource(R.drawable.bg_rectangle_white_round_20_dp)
            }
        }
    }

    private fun initCancelButtonListener() {
        binding.tvCancel.setOnClickListener {
            dismiss()
        }
    }

    private fun initCheckButtonListener() {
        binding.tvCheck.setOnClickListener {
            dismiss()
            positiveButtonClickListener()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "MetamonDialog"
        private var title = ""
        private var body = ""
        private lateinit var positiveButtonClickListener: () -> Unit

        fun newInstance(
            title: String,
            body: String,
            positiveButtonClickListener: () -> Unit
        ): MetamonDialogFragment {
            this.title = title
            this.body = body
            this.positiveButtonClickListener = positiveButtonClickListener
            return MetamonDialogFragment()
        }
    }
}
