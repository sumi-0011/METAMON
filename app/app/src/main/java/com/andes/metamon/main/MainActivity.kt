package com.andes.metamon.main

import android.Manifest
import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.andes.metamon.R
import com.andes.metamon.core.presentation.ImageBottomSheetDialogFragment
import com.andes.metamon.databinding.ActivityMainBinding
import com.andes.metamon.utils.BindingActivity
import com.andes.metamon.utils.setOnSingleClickListener
import com.andes.metamon.utils.shortToast
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import java.io.File

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initTransactionToHome()
        syncBottomNavWithNavController()
        setupUI()
    }

    @SuppressLint("ResourceType")
    private fun initTransactionToHome() {
        transactionToHome = {
            findViewById<BottomNavigationView>(R.id.bottom_nav)
                .selectedItemId = R.menu.menu_main
        }
    }

    private fun syncBottomNavWithNavController() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        findViewById<BottomNavigationView>(R.id.bottom_nav)
            .setupWithNavController(navController)
    }

    private fun setupUI() {
        binding.fabPost.setOnSingleClickListener {
            ImageBottomSheetDialogFragment(
                onGalleryClick = ::getImageFromGallery,
                onCameraClick = ::getImageFromCamera
            ).show(
                supportFragmentManager,
                this.javaClass.name
            )
        }
    }

    private fun getImageFromCamera() {
        cameraPermissionLauncher.launch(Manifest.permission.CAMERA)
    }

    private val getCameraResult = registerForActivityResult(
        ActivityResultContracts.TakePicturePreview()
    ) {
        try {
            mainViewModel.uploadAndDownloadFile(
                folderName = "example",
                userId = 1L,
                fileName = "12312312",
                bitmapToFile(this, it ?: throw Exception())
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private val cameraPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) { /* 카메라 권한 허용 */
                getCameraResult.launch(null)
            } else { /* 카메라 권한 허용 안함 */
                shortToast("카메라 권한을 허용해야 합니다.")
            }
        }

    private fun getImageFromGallery() {
        galleryResult.launch("image/*")
    }

    private val galleryResult = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            mainViewModel.uploadAndDownloadFile(
                folderName = "123123",
                userId = 1L,
                fileName = "123123",
                File(
                    createCopyAndReturnRealPath(
                        this,
                        it
                    ).toString()
                )
            )
            Log.d("okhttp", it.toString())
        }
    }

    companion object {
        lateinit var transactionToHome: () -> Unit
    }
}