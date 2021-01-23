package com.example.desafio_dhmarvel_android.model.comics.page

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.example.desafio_dhmarvel_android.model.comics.Result

class ComicsDataSourceFactory: DataSource.Factory<Int,Result >() {

    private val comicsLiveDataSource = MutableLiveData<PageKeyedDataSource<Int, Result>>()

    override fun create(): DataSource<Int, Result> {
        val comicsDataSource = ComicsPageKeyedDataSource()

        comicsLiveDataSource.postValue(comicsDataSource)
        return comicsDataSource
    }

    fun getComicsLiveDataSource(): MutableLiveData<PageKeyedDataSource<Int, Result>> {
        return comicsLiveDataSource
    }
}