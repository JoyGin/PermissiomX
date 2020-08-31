package com.joygin.permissionx

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.joygin.library.PermissionX
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        makeCall.setOnClickListener {
            PermissionX.request(this, android.Manifest.permission.CALL_PHONE){ allGranted, deniedList ->
                if (allGranted){
                    call()
                }else{
                    Toast.makeText(this,"You denied $deniedList", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    @SuppressLint("MissingPermission")
    private fun call() {
        try {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:10086")
            startActivity(intent)
        }catch (e: Exception){
            e.printStackTrace()
        }

    }
}
