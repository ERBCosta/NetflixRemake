package co.tiagoaguiar.netflixremake

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

//MainAdapter é o adaptador da tela principal e filha do RecyclerViiew.Adapater
class MainAdapter : RecyclerView.Adapter<MainAdapter.MovieViewHolder>() {

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
    }

    override fun getItemCount(): Int {
        return 60
    }

    //MovieViewHolder é a célula do filme e herda as propriedades do RecyclerView.ViewHolder
    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}