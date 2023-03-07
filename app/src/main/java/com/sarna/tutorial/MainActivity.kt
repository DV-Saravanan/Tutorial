package com.sarna.tutorial

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sarna.tutorial.retrofit.RetroWebservice
import com.sarna.tutorial.retrofit.WebserviceInterface
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ser = RetroWebservice(this)
        ser.invokeWebservice("", "", object : WebserviceInterface {
            override fun onWebserviceSuccess(strRes: String) {
                var s = strRes.toString()
                Toast.makeText(this@MainActivity,s,Toast.LENGTH_LONG).show()
            }

            override fun onWebserviceFail(strRes: String) {
                var s = strRes.toString()
                Toast.makeText(this@MainActivity,s,Toast.LENGTH_LONG).show()
            }
        })
    }
}