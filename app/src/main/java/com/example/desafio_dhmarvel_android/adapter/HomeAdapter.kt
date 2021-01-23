package com.example.desafio_dhmarvel_android.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.desafio_dhmarvel_android.R
import com.example.desafio_dhmarvel_android.databinding.ComicItemBinding
import com.example.desafio_dhmarvel_android.model.comics.Result

class HomeAdapter (
    private val onClicked: (Result?) -> Unit
) : PagedListAdapter<Result, HomeAdapter.ViewHolder>(Result.DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ComicItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), onClicked)
    }

    class ViewHolder(
        private val binding: ComicItemBinding
    ): RecyclerView.ViewHolder(
        binding.root
    ) {

        fun bind(hq: Result?,onClicked: (Result?) -> Unit) = with(binding) {
            Glide.with(itemView.context)
                .load(hq?.thumbnail?.path)
                .placeholder(R.drawable.logo)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(cvImageCardMenu)
            tvNameRecyclerViewMenu.text = "#${hq?.issueNumber}"
            itemView.setOnClickListener {
                onClicked(hq)
            }

        }
    }
}