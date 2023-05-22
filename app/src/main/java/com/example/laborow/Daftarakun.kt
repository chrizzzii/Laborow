package com.example.laborow


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.laborow.databinding.ActivityDaftarakunBinding
import com.google.firebase.auth.FirebaseAuth

class Daftarakun : AppCompatActivity() {

    private lateinit var binding: ActivityDaftarakunBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaftarakunBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.signupButton.setOnClickListener{
            val email = binding.signupEmail.text.toString()
            val password = binding.signupPassword.text.toString()
            val confirmPassword = binding.signupConfirm.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()){
                if (password == confirmPassword){

                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
                        if (it.isSuccessful){
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "Password does not matched", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }

        binding.loginRedirectTextbutton.setOnClickListener {
            val loginIntent = Intent(this, LoginActivity::class.java)
            startActivity(loginIntent)
        }

        binding.daftarasprak.setOnClickListener {
            val daftarasprak = Intent(this, SignupActivity::class.java)
            startActivity(daftarasprak)
        }

    }
}