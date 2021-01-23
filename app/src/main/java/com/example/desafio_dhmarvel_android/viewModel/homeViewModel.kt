package com.example.desafio_dhmarvel_android.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.example.desafio_dhmarvel_android.utils.Constants.Paging.PAGE_SIZE
import com.example.desafio_dhmarvel_android.model.comics.Result
import com.example.desafio_dhmarvel_android.model.comics.page.ComicsDataSourceFactory

class homeViewModel: ViewModel() {
    var comicsPagedList: LiveData<PagedList<Result>>? = null
    private var comicsLiveDataSource: LiveData<PageKeyedDataSource<Int, Result>>? = null

    init {
        comicsData()
    }

    fun comicsData(){
        val comicsDataSourceFactory = ComicsDataSourceFactory()

        comicsLiveDataSource = comicsDataSourceFactory.getComicsLiveDataSource()

        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(PAGE_SIZE).build()

        comicsPagedList = LivePagedListBuilder(comicsDataSourceFactory, pagedListConfig)
            .build()
    }
}