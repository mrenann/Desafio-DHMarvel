package com.example.desafio_dhmarvel_android.view.activity

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafio_dhmarvel_android.model.comics.Result
import com.example.desafio_dhmarvel_android.R
import com.example.desafio_dhmarvel_android.adapter.HomeAdapter
import com.example.desafio_dhmarvel_android.databinding.ActivityHomeBinding
import com.example.desafio_dhmarvel_android.utils.Constants
import com.example.desafio_dhmarvel_android.viewModel.homeViewModel

class HomeActivity : AppCompatActivity() {
    private lateinit var viewModel: homeViewModel
    private lateinit var binding: ActivityHomeBinding

    private val homeAdapter : HomeAdapter by lazy {
        HomeAdapter {
            val comicCliked = it
            comicCliked?.let{ hq->
                val intent = Intent(this, ComicDetailedActivity::class.java)
                intent.putExtra(Constants.ConstantsHqs.BASE_HQ_KEY, it)

                startActivity(intent)
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(homeViewModel::class.java)

        setupRecyclerView()
        loadContentComics()

    }

    private fun loadContentComics() {
        viewModel.comicsPagedList?.observe(this) { pagedList ->
            homeAdapter.submitList(pagedList)
        }
    }

    private fun setupRecyclerView() {
        binding.rvCards.apply {
            layoutManager = GridLayoutManager(this@HomeActivity,3)
            adapter = homeAdapter
        }
    }
}