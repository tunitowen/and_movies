package and.digial.movies.ui.search

import and.digial.movies.R
import and.digial.network.model.MovieResult
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.squareup.picasso.Picasso

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

    val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"

    var title: MaterialTextView = itemView.findViewById(R.id.result_title)
    var imageView: ImageView = itemView.findViewById(R.id.result_image)

    fun bind(movieResult: MovieResult) {
        title.text = movieResult.title

        Picasso.get()
            .load("$IMAGE_BASE_URL/${movieResult.backdropPath}")
            .error(R.drawable.ic_baseline_broken_image_24)
            .into(imageView)
    }
}