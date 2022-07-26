package com.example.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import com.example.movie.databinding.ActivityMovieBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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
        GlobalScope.launch(Dispatchers.Main) {
            var list: List<Movie> = RetrofitHelper.getMovieApi().getMovie()
            var movie = list[0]
            binding.textViewMovieDescription.text = movie.desc
            binding.textViewMovieTitle.text = movie.name
            binding.imageViewPreview.setImageResource(R.drawable.preview2)
            Glide
                .with(this@MainActivity)
                .load(movie.imageUrl)
                .into(binding.imageViewPreview)
        }
    }
}