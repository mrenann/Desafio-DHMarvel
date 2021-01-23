package com.example.desafio_dhmarvel_android.model.comics.page

import androidx.paging.PageKeyedDataSource
import com.example.desafio_dhmarvel_android.api.ResponseAPI
import com.example.desafio_dhmarvel_android.extensions.image
import com.example.desafio_dhmarvel_android.model.comics.Comics
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import com.example.desafio_dhmarvel_android.model.comics.Result
import com.example.desafio_dhmarvel_android.repository.homeRepository
import com.example.desafio_dhmarvel_android.utils.Constants.Paging.FIRST_PAGE


class ComicsPageKeyedDataSource : PageKeyedDataSource<Int, Result>() {

    private val repository by lazy {
        homeRepository()
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Result>
    ) {
        CoroutineScope(IO).launch {
            when(val response = repository.getComics()) {
                is ResponseAPI.Success -> {
                    val data = response.data as Comics
                    data.data?.results?.forEach {result ->
                        result.thumbnail?.path = result.thumbnail?.path?.image()
                        result.images?.forEach {
                            it.path = it.path?.image()
                        }
                        result.description?.let { } ?: run {
                            result.description = "Description not Found"
                        }
                    }
                    data.data?.results?.let { callback.onResult(it, null, FIRST_PAGE + 1) }
                }
                is ResponseAPI.Error -> {
                    callback.onResult(mutableListOf(), null, FIRST_PAGE + 1)
                }
            }
        }
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Result>
    ) {
        val page = params.key

        CoroutineScope(IO).launch {
            when(val response = repository.getComics()) {
                is ResponseAPI.Success -> {
                    val data = response.data as Comics
                    data.data?.results?.forEach {result ->
                        result.thumbnail?.path = result.thumbnail?.path?.image()
                        result.images?.forEach {
                            it.path = it.path?.image()
                        }
                        result.description?.let { } ?: run {
                            result.description = "Descrição não Encontrada"
                        }
                    }
                    data.data?.results?.let { callback.onResult(it, page + 1) }
                }
                is ResponseAPI.Error -> {
                    callback.onResult(mutableListOf(), page + 1)
                }
            }
        }
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Result>
    ) {
        val page = params.key

        CoroutineScope(IO).launch {
            when(val response = repository.getComics()) {
                is ResponseAPI.Success -> {
                    val data = response.data as Comics
                    data.data?.results?.forEach {result ->
                        result.thumbnail?.path = result.thumbnail?.path?.image()
                        result.images?.forEach {
                            it.path = it.path?.image()
                        }
                        result.description?.let { } ?: run {
                            result.description = "Descrição não Encontrada"
                        }
                    }
                    data.data?.results?.let { callback.onResult(it, page - 1) }
                }
                is ResponseAPI.Error -> {
                    callback.onResult(mutableListOf(), page - 1)
                }
            }
        }
    }
}