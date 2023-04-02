package com.example.laborow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.laborow.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth
import com.example.laborow.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var  database:DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        binding.signupButton.setOnClickListener {
            val firstName=binding.userNameTextEt.text.toString()
            val  lastname=binding.lastNameTextEt.text.toString()
            val  email=binding.signupEmail.text.toString()
            val  password=binding.signupPassword.text.toString()
            val username=binding.userNameTextEt.text.toString()

            database=FirebaseDatabase.getInstance().getReference("Users")
            val  user=User(firstName,lastname,email,password,username)
            database.child(username).setValue(user).addOnSuccessListener {
                binding.nameTextEt.text?.clear()
                binding.lastNameTextEt.text?.clear()
                binding.signupEmail.text?.clear()
                binding.signupPassword.text?.clear()
                binding.userNameTextEt.text?.clear()

                Toast.makeText(this,"Signup berhasil!", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener{
                Toast.makeText(this,"Signup gagal! ", Toast.LENGTH_SHORT).show()
            }


        }
        binding.loginRedirectText.setOnClickListener {
            val loginIntent = Intent(this, LoginActivity::class.java)
            startActivity(loginIntent)
        }
        binding.loginRedirectTextbutton.setOnClickListener {
            val loginIntent = Intent(this, LoginActivity::class.java)
            startActivity(loginIntent)
        }
    }


}


