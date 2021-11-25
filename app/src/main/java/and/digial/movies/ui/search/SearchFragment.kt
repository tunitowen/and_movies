package and.digial.movies.ui.search

import and.digial.movies.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment: Fragment() {

    private val viewModel: SearchViewModel by viewModel()

    lateinit var textInputLayout: TextInputLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        textInputLayout = view.findViewById(R.id.search_text_input_layout)
        return view
    }

    override fun onStart() {
        super.onStart()

        textInputLayout.setEndIconOnClickListener {
            viewModel.search(textInputLayout.editText?.text.toString())
        }

        viewModel.searchResult.observe(this, { result ->
            Toast.makeText(requireContext(), "Got a Search Result", Toast.LENGTH_SHORT).show()
        })
    }
}