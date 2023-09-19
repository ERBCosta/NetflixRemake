package co.tiagoaguiar.netflixremake

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import co.tiagoaguiar.netflixremake.model.Movie
//aqui é a lista horizontal
//MainAdapter é o adaptador da tela principal e filha do RecyclerViiew.Adapater
class MovieAdapter(private val movies: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    //onCreateViewHolder - onBindViewHolder - getItemCount 3 itens obrigatórios para o RecyclerView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        /* método que espera que infle o layout para ele e passe qual é o viewHolder para ele (movieViewHolder)
        porém o layoutInflater é uma propriedade que só fica visível dentro da activity (appAppCompatActivity())
        então utilizamos LayoutInflater.from que vai instanciar a partir do contexto parent.context
        isso é feito quando separamos o adapter em outro arquivo */
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        //Esse método é disparado sempre que houver rolagem
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    //MovieViewHolder é a célula do filme e herda as propriedades do RecyclerView.ViewHolder
    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Movie) {
            val imageCover: ImageView = itemView.findViewById(R.id.img_cover)

            // TODO: aqui vai ser trocado por um URL que virá do servidor
            //imageCover.setImageResource(movie.coverUrl)
        }

    }

}