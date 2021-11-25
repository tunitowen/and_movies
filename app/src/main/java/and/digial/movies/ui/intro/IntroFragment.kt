package and.digial.movies.ui.intro

import and.digial.movies.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton

class IntroFragment: Fragment() {

    lateinit var startButton: MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_intro, container, false)
        startButton = view.findViewById(R.id.intro_start_button)
        return view
    }

    override fun onStart() {
        super.onStart()
        startButton.setOnClickListener {
            findNavController().navigate(IntroFragmentDirections.introToSearch())
        }
    }

}