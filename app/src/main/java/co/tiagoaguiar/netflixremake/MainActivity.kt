package co.tiagoaguiar.netflixremake

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.tiagoaguiar.netflixremake.model.Movie

class MainActivity : AppCompatActivity() {
    //M-V-C: [model - view - controler] activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("Teste", "onCreate")

        val movies = mutableListOf<Movie>()
        for (i in 0 until 60) {
            val movie = Movie(R.drawable.movie_4)
            movies.add(movie)
        }

        val adapter = MainAdapter(movies)
        val rv: RecyclerView = findViewById(R.id.rv_main)
        rv.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rv.adapter = adapter
    }

    //essa função private só está visivel na classe mainactivity e inner clas pra dizer que é uma classe interna na mainactivity


}