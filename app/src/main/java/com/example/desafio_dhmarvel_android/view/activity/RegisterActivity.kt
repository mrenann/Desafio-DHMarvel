package com.example.desafio_dhmarvel_android.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafio_dhmarvel_android.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btCardRegister.setOnClickListener {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
        }

        ibRegisterBack.setOnClickListener {
            finish()
        }
    }
}