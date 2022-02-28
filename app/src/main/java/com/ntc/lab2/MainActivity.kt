package com.ntc.lab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ntc.lab2.databinding.ActivityMainBinding
import com.ntc.lab2.recyclerview.Music
import com.ntc.lab2.recyclerview.MusicAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listMusics.run {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = MusicAdapter(Musics)
        }

        binding.addmusic.setOnClickListener {
            val intent = Intent(this@MainActivity, AddMusic::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        binding.listMusics.adapter?.notifyDataSetChanged()
    }

    companion object {
        val Musics = mutableListOf<Music>()
    }
}