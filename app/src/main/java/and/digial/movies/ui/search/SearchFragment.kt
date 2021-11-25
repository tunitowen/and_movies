package and.digial.movies.ui.search

import and.digial.movies.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputLayout
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment: Fragment() {

    private val viewModel: SearchViewModel by viewModel()

    lateinit var textInputLayout: TextInputLayout
    lateinit var recyclerView: RecyclerView
    private val adapter = SearchAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        textInputLayout = view.findViewById(R.id.search_text_input_layout)
        recyclerView = view.findViewById(R.id.search_recycler_view)
        return view
    }

    override fun onStart() {
        super.onStart()

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        textInputLayout.setEndIconOnClickListener {
            viewModel.search(textInputLayout.editText?.text.toString())
        }

        viewModel.searchResult.observe(this, { result ->
            Toast.makeText(requireContext(), "Got a Search Result", Toast.LENGTH_SHORT).show()
            adapter.items = result.results
            adapter.notifyDataSetChanged()
        })
    }
}