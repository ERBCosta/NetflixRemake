package co.tiagoaguiar.netflixremake

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("Teste", "onCreate")

        val adapter = MainAdapter()
        val rv: RecyclerView = findViewById(R.id.rv_main)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter
    }

    //essa função private só está visivel na classe mainactivity e inner clas pra dizer que é uma classe interna na mainactivity
    //MainAdapter é o adaptador da tela principal e filha do RecyclerViiew.Adapater
    private inner class MainAdapter : RecyclerView.Adapter<MainAdapter.MovieViewHolder>() {

        //onCreateViewHolder - onBindViewHolder - getItemCount 3 itens obrigatórios para o RecyclerView

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
            //método que espera que infle o layout para ele e passe qual é o viewHolder para ele (movieViewHolder)
            val view = layoutInflater.inflate(R.layout.movie_item, parent, false)
            return MovieViewHolder(view)
        }

        override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
            //Esse método é disparado sempre que houver rolagem
        }

        override fun getItemCount(): Int {
            return 60
        }
        //MovieViewHolder é a célula do filme e herda as propriedades do RecyclerView.ViewHolder
        private inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        }


    }


}