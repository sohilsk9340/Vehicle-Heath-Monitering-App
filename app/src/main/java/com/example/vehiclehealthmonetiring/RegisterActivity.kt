package com.example.vehiclehealthmonetiring

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject

class RegisterActivity : AppCompatActivity() {
    val Api_url: String = "https://vehicle-app-api.onrender.com/register"
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val ownerName = findViewById<EditText>(R.id.ownerName)
        val vehicleNumber = findViewById<EditText>(R.id.VehicleNumber)
        val chassieNumber = findViewById<EditText>(R.id.chassiNumber)
        val carBrand = findViewById<EditText>(R.id.carBrand)
        val dateOfPurchase = findViewById<EditText>(R.id.dateOfPurchase)
        val btnRegister = findViewById<Button>(R.id.register)
        val btnStatus = findViewById<Button>(R.id.status)

        btnRegister.setOnClickListener {
            val owner: String = ownerName.text.toString()
            val numberPlate: String = vehicleNumber.text.toString()
            val chassie: String = chassieNumber.text.toString()
            val brand: String = carBrand.text.toString()
            val date: String = dateOfPurchase.text.toString()

            val register = JSONObject()
            val requestQue: RequestQueue = Volley.newRequestQueue(this)

            try {
                register.put("owner",owner)
                register.put("numberPlate",numberPlate)
                register.put("chassie",chassie)
                register.put("brand",brand)
                register.put("date",date)
            }catch (e: JSONException){
                e.printStackTrace()
            }

            val requst = JsonObjectRequest(
                Request.Method.POST,
                Api_url,
                register,
                { response ->
                   Toast.makeText(this,"Submitted Successfully", Toast.LENGTH_SHORT).show()
                },
                { error ->
                   Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            )

            requestQue.add(requst)

        }

        btnStatus.setOnClickListener {
            startActivity(Intent(this, StatusActivity2::class.java))
        }
    }
}