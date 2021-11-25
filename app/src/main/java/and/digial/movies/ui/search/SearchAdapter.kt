package and.digial.movies.ui.search

import and.digial.movies.R
import and.digial.network.model.MovieResult
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView

class SearchAdapter: RecyclerView.Adapter<MovieResultViewHolder>() {

    var items: List<MovieResult> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieResultViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieResultViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieResultViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}

class MovieResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var title: MaterialTextView = itemView.findViewById(R.id.result_title)

    fun bind(movieResult: MovieResult) {
        title.text = movieResult.title
    }
}