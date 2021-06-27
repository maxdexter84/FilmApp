package ru.maxdexter.filmapp.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.maxdexter.filmapp.App
import ru.maxdexter.filmapp.databinding.FilmsListFragmentBinding

class FilmsListFragment : Fragment() {

    companion object {
        fun newInstance() = FilmsListFragment()
    }

    private lateinit var viewModel: FilmsListViewModel
    private lateinit var binding: FilmsListFragmentBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.filmsFragment()
            .create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FilmsListFragmentBinding.inflate(layoutInflater)
        return binding.root
    }


}