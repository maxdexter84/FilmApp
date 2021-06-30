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
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import ru.maxdexter.filmapp.App
import ru.maxdexter.filmapp.databinding.FilmsListFragmentBinding
import ru.maxdexter.filmapp.domain.common.LoadState
import ru.maxdexter.filmapp.ui.adapters.MovieAdapter
import ru.maxdexter.filmapp.ui.model.MovieUI
import ru.maxdexter.filmapp.utils.hide
import ru.maxdexter.filmapp.utils.show
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

        stateObserver()


        return binding.root
    }

    private fun stateObserver() {
        viewModel.data.observe(viewLifecycleOwner, {
            when (it) {
                is LoadState.Error -> {
                    Log.e("LOAD_ERROR", it.e.message.toString())
                    binding.progress.hide()
                    showSnackbar()

                }
                is LoadState.Success -> {
                    movieAdapter.submitList(it.data as List<MovieUI>)
                    binding.recycler.adapter = movieAdapter
                    binding.progress.hide()
                }
                LoadState.Loading -> {
                    binding.progress.show()
                }
            }
        })
    }

    private fun showSnackbar() {
        Snackbar.make(binding.root, "Ошибка соединения!", Snackbar.LENGTH_LONG)
            .setAction("Повторить") {
                viewModel.loadData()
            }.show()
    }




}