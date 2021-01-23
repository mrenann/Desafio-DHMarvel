package com.example.desafio_dhmarvel_android.view.activity

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.desafio_dhmarvel_android.R
import com.example.desafio_dhmarvel_android.databinding.ActivityComicDetailedBinding
import com.example.desafio_dhmarvel_android.databinding.ActivityHomeBinding
import com.example.desafio_dhmarvel_android.extensions.getDate
import com.example.desafio_dhmarvel_android.utils.Constants.ConstantsHqs
import com.example.desafio_dhmarvel_android.model.comics.Result
import com.example.desafio_dhmarvel_android.utils.Constants
import com.example.desafio_dhmarvel_android.utils.Constants.ConstantsHqs.BASE_HQ_KEY
import kotlinx.android.synthetic.main.activity_comic_detailed.*
import kotlinx.android.synthetic.main.fragment_poster.*
import java.time.LocalDate
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class ComicDetailedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityComicDetailedBinding
    private var hq:Result? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComicDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        window.statusBarColor = Color.TRANSPARENT

        hq = intent.getParcelableExtra(BASE_HQ_KEY)
        hq?.let {
            Glide.with(this)
                .load(it.images?.get(0)?.path)
                .placeholder(R.drawable.logo)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.ivBackDrop)

            Glide.with(this)
                .load(it.thumbnail?.path)
                .placeholder(R.drawable.logo)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.ivHQ)

            binding.titulo.text = it.title
            binding.description.text = it.description
            val parsed = LocalDate.parse(it.dates?.get(0)?.date?.getDate())
            //val date = LocalDate.parse(?.getDate(), DateTimeFormatter.ISO_DATE)
            binding.published.text = ("Published: ${parsed.month.toString().toLowerCase().capitalize()} ${parsed.dayOfMonth}, ${parsed.year}")
            if(it.prices?.get(0)?.price=="0"){
                binding.price.text = ("Price: Free")
            }else{
                binding.price.text = ("Price: $ "+ (it.prices?.get(0)?.price ?: "-"))
            }

            binding.pages.text = ("Pages: "+it.pageCount)
        }

        binding.ivArrowBack.setOnClickListener {
            finish()
        }
        binding.ivHQ.setOnClickListener {
            val dialog = Dialog(this@ComicDetailedActivity)
            dialog.setContentView(R.layout.fragment_poster)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            Glide.with(this@ComicDetailedActivity)
                .load(hq?.thumbnail?.path)
                .placeholder(R.drawable.logo)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(dialog.imageDialog)

            dialog.show()
        }
    }
}