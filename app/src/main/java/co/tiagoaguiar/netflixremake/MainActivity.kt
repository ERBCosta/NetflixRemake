package co.tiagoaguiar.netflixremake

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.tiagoaguiar.netflixremake.model.Category
import co.tiagoaguiar.netflixremake.model.Movie

class MainActivity : AppCompatActivity() {
    //M-V-C: [model - view - controler] activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("Teste", "onCreate")

        val categories = mutableListOf<Category>()
        for (j in 0 until 10) {
            val movies = mutableListOf<Movie>()
            for (i in 0 until 15) {
                val movie = Movie(R.drawable.movie)
                movies.add(movie)
            }
            val category = Category("cat $j", movies)
            categories.add(category)
        }

        //na vertical a lista (MainAdapter) de categorias
        //e dentro de cada item [TextView + RecyclerView horizontal]
        // (cada categoria) teremos:
        // uma lista (movieAdapter) de filmes que é a (ImageView)
        val adapter = CategoryAdapter(categories)
        val rv: RecyclerView = findViewById(R.id.rv_main)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter
    }

    //essa função private só está visivel na classe mainactivity e inner clas pra dizer que é uma classe interna na mainactivity


}