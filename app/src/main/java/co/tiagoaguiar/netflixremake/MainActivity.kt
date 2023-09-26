package co.tiagoaguiar.netflixremake

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.tiagoaguiar.netflixremake.model.Category
import co.tiagoaguiar.netflixremake.model.Movie
import co.tiagoaguiar.netflixremake.util.CategoryTask

class MainActivity : AppCompatActivity() {
    //M-V-C: [model - view - controler] activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("Teste", "onCreate")

        val categories = mutableListOf<Category>()
        /*       for (j in 0 until 10) {
                   val movies = mutableListOf<Movie>()
                   for (i in 0 until 15) {
                       val movie = Movie(R.drawable.movie)
                       movies.add(movie)
                   }
                   val category = Category("cat $j", movies)
                   categories.add(category)
               }*/

        /*na vertical a lista (MainAdapter) de categorias
        e dentro de cada item [TextView + RecyclerView horizontal]
        (cada categoria) teremos:*/
        val adapter = CategoryAdapter(categories)
        val rv: RecyclerView = findViewById(R.id.rv_main)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter

        CategoryTask().execute("https://api.tiagoaguiar.co/netflixapp/home?apiKey=bdb43885-7881-4662-8eb2-9aa94e574be2")
    }

    //essa função private só está visivel na classe mainactivity e inner clas pra dizer que é uma classe interna na mainactivity


}