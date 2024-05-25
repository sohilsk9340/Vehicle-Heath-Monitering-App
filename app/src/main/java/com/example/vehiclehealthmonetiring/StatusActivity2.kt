package com.example.vehiclehealthmonetiring

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject

class StatusActivity2 : AppCompatActivity() {
    val url: String = "https://vehicle-app-api.onrender.com/status"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status2)

        val text1 = findViewById<TextView>(R.id.text1)
        val text2 = findViewById<TextView>(R.id.text2)
        val text3 = findViewById<TextView>(R.id.text3)
        val text4 = findViewById<TextView>(R.id.text4)



        val requestQueue: RequestQueue = Volley.newRequestQueue(this)

        val status = JsonObjectRequest(
            Request.Method.POST,
            url,
            null,
            { response ->
               try {
                   val vehicleStatus: String = response.getString("vehicleStatus")
                   val engineHealth: String = response.getString("engineHealth")
                   val expirePollution: String = response.getString("expirePollution")
                   val accident: String = response.getString("accident")

                   text1.text = vehicleStatus
                   text2.text = engineHealth
                   text3.text = expirePollution
                   text3.text = accident

               }catch (e: Exception){
                   e.printStackTrace()
               }
            },
            { error ->
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        )
        requestQueue.add(status)
//        val vehicleStatus = text1.text.toString()
//        val engineHealth = text2.text.toString()
//        val expirePollution = text3.text.toString()
//        val accident = text4.text.toString()
    }
}