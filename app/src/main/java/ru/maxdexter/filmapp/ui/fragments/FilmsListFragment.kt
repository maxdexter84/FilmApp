package ru.maxdexter.filmapp.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ru.maxdexter.filmapp.App
import ru.maxdexter.filmapp.databinding.FilmsListFragmentBinding
import ru.maxdexter.filmapp.domain.common.LoadState
import ru.maxdexter.filmapp.ui.adapters.MovieAdapter
import ru.maxdexter.filmapp.ui.model.MovieUI
import javax.inject.Inject

class FilmsListFragment : Fragment() {

    companion object {
        fun newInstance() = FilmsListFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<FilmsListViewModel> { viewModelFactory }

    private lateinit var binding: FilmsListFragmentBinding
    private lateinit var movieAdapter: MovieAdapter
    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.filmsFragment()
            .create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FilmsListFragmentBinding.inflate(layoutInflater, container, false)
        movieAdapter = MovieAdapter()
        binding.recycler.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        viewModel.data.observe(viewLifecycleOwner, {
            when (it) {
                is LoadState.Error -> {
                    Log.e("LOAD_ERROR", it.e.message.toString())
                }
                is LoadState.Success -> {
                    movieAdapter.submitList(it.data as List<MovieUI>)
                    binding.recycler.adapter = movieAdapter
                }
                LoadState.Loading -> {
                }
            }
        })


        return binding.root
    }


}