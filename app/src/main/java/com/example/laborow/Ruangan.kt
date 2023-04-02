package com.example.laborow

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
class Ruangan : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ruangan)

        // use arrayadapter and define an array
        val arrayAdapter: ArrayAdapter<*>
        val users = arrayOf(
            "A201 \nKapasitas: 100 orang \nFasilitas: Sound, AC, Proyektor", "A102 \n" +
                    "Kapasitas: 120 orang \n" +
                    "Fasilitas: Sound, AC, Proyektor", "A101 \n" +
                    "Kapasitas: 130 orang \n" +
                    "Fasilitas: Sound, AC, Proyektor",
            "Lab. RPL \n" +
                    "Kapasitas: 70 orang \n" +
                    "Fasilitas: Sound, AC, Proyektor", "Lab. PJK \n" +
                    "Kapasitas: 90 orang \n" +
                    "Fasilitas: Sound, AC, Proyektor", "Lab. Embedded \n" +
                    "Kapasitas: 60 orang \n" +
                    "Fasilitas: Sound, AC, Proyektor", "Lab. Multimedia \n" +
                    "Kapasitas: 80 orang \n" +
                    "Fasilitas: Sound, AC, Proyektor", "TL. D305 \n" +
                    "Kapasitas: 150 orang \n" +
                    "Fasilitas: Sound, AC, Proyektor", "Ruang Bersama \nKapasitas: 200 orang \nFasilitas: Sound, AC, Proyektor",
            "Gedung Bersama \nKapasitas: 150 orang \nFasilitas: Sound, AC, Proyektor",
            "Kampus Bersama \nKapasitas: 200 orang \nFasilitas: Sound, AC, Proyektor",
            "Laboratorium Bersama \nKapasitas: 100 orang \nFasilitas: Sound, AC, Proyektor"
        )

        // access the listView from xml file
        var mListView = findViewById<ListView>(R.id.userlist)
        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, users)
        mListView.adapter = arrayAdapter
    }
}