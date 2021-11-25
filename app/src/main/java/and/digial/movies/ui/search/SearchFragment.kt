package and.digial.movies.ui.search

import and.digial.movies.R
import android.app.Activity
import android.os.Bundle
import android.view.KeyEvent.KEYCODE_ENTER
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import org.koin.androidx.viewmodel.ext.android.viewModel


class SearchFragment : Fragment() {

    private val viewModel: SearchViewModel by viewModel()

    lateinit var textInputLayout: TextInputLayout
    lateinit var editText: TextInputEditText
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
        editText = view.findViewById(R.id.search_text_input_edit_text)
        return view
    }

    override fun onStart() {
        super.onStart()

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        adapter.clickListener = { result ->
            findNavController().navigate(SearchFragmentDirections.searchToRabbit(result.title, result.id))
        }

        textInputLayout.setEndIconOnClickListener {
            searchAndHideKeyboard(textInputLayout.editText?.text.toString())
        }
        editText.setOnEditorActionListener { textView, actionId, keyEvent ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH || keyEvent.keyCode == KEYCODE_ENTER) {
                searchAndHideKeyboard(editText.text.toString())
                true
            }
            false
        }

        viewModel.searchResult.observe(this, { result ->
            Toast.makeText(requireContext(), "Got a Search Result", Toast.LENGTH_SHORT).show()
            adapter.items = result.results
            adapter.notifyDataSetChanged()
        })
    }

    private fun searchAndHideKeyboard(term: String) {
        viewModel.search(term)
        val inputMethodManager = requireContext().getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(editText.windowToken, 0)
    }
}