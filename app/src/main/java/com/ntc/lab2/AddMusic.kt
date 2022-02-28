package com.ntc.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ntc.lab2.databinding.ActivityAddMusicBinding
import com.ntc.lab2.recyclerview.Music

class AddMusic : AppCompatActivity() {
    private lateinit var binding: ActivityAddMusicBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddMusicBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.save.setOnClickListener {
            val name = binding.edtName.text.toString()
            val singer = binding.edtSinger.text.toString()

            if(name.length == 0 || singer.length == 0){
                Toast.makeText(this, "Please complete all information", Toast.LENGTH_SHORT).show()
            }else {

                val music = Music(name, singer)

                MainActivity.Musics.add(music)

                finish()
            }
        }
    }
}