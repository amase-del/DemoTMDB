package com.example.demotmdb.ui.listing

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demotmdb.data.MovieRepository
import com.example.demotmdb.model.Result
import com.example.demotmdb.model.TrendingMovieResponse
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect

/**
 * ViewModel for ListingActivity
 */
class ListingViewModel @ViewModelInject constructor(private val movieRepository: MovieRepository) :
        ViewModel() {

    private val _movieList = MutableLiveData<Result<TrendingMovieResponse>>()
    val movieList = _movieList

    init {
        fetchMovies()
    }

    private fun fetchMovies() {
        viewModelScope.launch {
            movieRepository.fetchTrendingMovies().collect {
                _movieList.value = it
            }
        }
    }
}