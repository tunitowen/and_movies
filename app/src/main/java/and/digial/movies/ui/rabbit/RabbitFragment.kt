package and.digial.movies.ui.rabbit

import and.digial.movies.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.textview.MaterialTextView
import org.koin.androidx.viewmodel.ext.android.viewModel

class RabbitFragment: Fragment() {

    private val viewModel: RabbitViewModel by viewModel()
    private val args: RabbitFragmentArgs by navArgs()

    lateinit var title: MaterialTextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_rabbit, container, false)
        title = view.findViewById(R.id.rabbit_title)
        return view
    }

    override fun onStart() {
        super.onStart()
        title.text = args.movieTitle
        viewModel.getRecommendations(args.movieId)
    }
}