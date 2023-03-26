package com.example.laborow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.laborow.databinding.ActivityCariAsprakBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CariAsprak : AppCompatActivity() {

    private lateinit var  binding:ActivityCariAsprakBinding
    private lateinit var database:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCariAsprakBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.readBtn.setOnClickListener {
            val  userName:String=binding.usernameet.text.toString()
            if(userName.isNotEmpty()){
                readData(userName)
            }else
            {
                Toast.makeText(this,"Masukkan username asprak!",Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun readData(userName: String) {
        database=FirebaseDatabase.getInstance().getReference("Users")
        database.child(userName).get().addOnSuccessListener {
            if (it.exists()){
                val firstName=it.child("firstName").value
                val lastName=it.child("lastname").value
                val email=it.child("email").value
                Toast.makeText(this,"Pencarian Ditemukan",Toast.LENGTH_SHORT).show()


                binding.usernameet.text.clear()
                binding.tvFirstName.text=firstName.toString()
                binding.tvLastName.text=lastName.toString()
                binding.tvEmail.text=email.toString()

            }else
            {
                Toast.makeText(this,"Asprak tidak ditemukan",Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener{
            Toast.makeText(this,"Gagal",Toast.LENGTH_SHORT).show()
        }

    }
}