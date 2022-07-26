package com.example.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.movie.databinding.ActivityMovieBinding

class MainActivity : AppCompatActivity() {
    // assign the _binding variable initially to null and
    // also when the view is destroyed again it has to be set to null
    private var _binding: ActivityMovieBinding? = null

    // with the backing property of the kotlin we extract
    // the non null value of the _binding
    private val binding
    get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textViewMovieDescription.text = getString(R.string.description_movie_totoro)
        binding.imageViewPreview.setImageResource(R.drawable.preview2)
    }
}