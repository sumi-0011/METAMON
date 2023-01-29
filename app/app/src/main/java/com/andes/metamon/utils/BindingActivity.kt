package com.andes.metamon.utils

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.andes.navigator.MainNavigator
import dagger.hilt.android.EntryPointAccessors
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import java.util.*

abstract class BindingActivity<T : ViewDataBinding>(
    @LayoutRes private val layoutRes: Int
) : AppCompatActivity() {
    lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)
        binding.lifecycleOwner = this
    }

    val mainNavigator: MainNavigator by lazy {
        EntryPointAccessors.fromActivity(
            this,
            Injector.MainNavigatorInjector::class.java
        ).mainNavigator()
    }

    /**
     * 이미지 Uri 를 파일의 절대경로로 변환해주는 메서드
     *
     * @author onseok
     * @param context
     * @param uri
     *
     * @return String?
     */
    fun createCopyAndReturnRealPath(
        context: Context, uri: Uri?
    ): String? {
        val contentResolver = context.contentResolver ?: return null
        val uuid = UUID.randomUUID().toString().replace("-", "")
        val fileName = "$uuid.jpg"
        val filePath = context.applicationInfo.dataDir + File.separator + fileName
        val file = File(filePath)
        try {
            val inputStream = contentResolver.openInputStream(uri!!) ?: return null
            val outputStream: OutputStream = FileOutputStream(file)
            val buf = ByteArray(1024)
            var len: Int
            while (inputStream.read(buf).also { len = it } > 0) outputStream.write(buf, 0, len)
            outputStream.close()
            inputStream.close()
        } catch (ignore: IOException) {
            return null
        }
        return file.absolutePath
    }

    /**
     * 비트맵 객체를 File 객체로 만들어주는 메소드
     *
     * @author onseok
     * @param context
     * @param bitmap
     *
     * @return File
     */
    fun bitmapToFile(context: Context, bitmap: Bitmap): File {
        val uuid = UUID.randomUUID().toString().replace("-", "")
        val fileName = "$uuid.jpg"
        val file = File(context.cacheDir, fileName)
        file.createNewFile()
        val out = FileOutputStream(file)
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out)
        out.close()
        return file
    }
}
