package com.example.laborow

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.laborow.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth



class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()


        binding.profile.setOnClickListener {
            val profileIntent = Intent(this, Profile::class.java)
            startActivity(profileIntent)
        }

        binding.cariasprak.setOnClickListener {
            val cariAsprakIntent = Intent(this, CariAsprak::class.java)
            startActivity(cariAsprakIntent)
        }

        binding.ruangan.setOnClickListener {
            val ruanganIntent = Intent(this, Ruangan::class.java)
            startActivity(ruanganIntent)
        }

        binding.kalender.setOnClickListener {
            val calendarIntent = Intent(this, Calendar::class.java)
            startActivity(calendarIntent)
        }

        binding.update.setOnClickListener {
            Toast.makeText(this, "Versi aplikasi sudah terbaru!", Toast.LENGTH_SHORT).show()
        }

        binding.logout.setOnClickListener {
            val logoutIntent = Intent(this, LoginActivity::class.java)
            startActivity(logoutIntent)
            Toast.makeText(this, "Logout berhasil!", Toast.LENGTH_SHORT).show()
        }


}}