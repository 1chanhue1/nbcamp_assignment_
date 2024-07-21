package com.chanhue.nbcamp_assignment

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.res.ResourcesCompat
import com.chanhue.nbcamp_assignment.databinding.ActivityDetailBinding
import com.google.android.material.snackbar.Snackbar
import java.text.DecimalFormat

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    private var isLike = false

    private val item: MyItem? by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("data", MyItem::class.java)
        } else {
            intent.getParcelableExtra<MyItem>("data")
        }
    }

    private val itemPosition: Int by lazy {
        intent.getIntExtra("position",0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("jblee","itemPosition = $itemPosition")

        binding.ivItemImage.setImageDrawable(item?.let {
            ResourcesCompat.getDrawable(resources, it.imageFileName, null)
        })

        binding.tvSellerName.text = item?.seller
        binding.tvSellerAddress.text = item?.address
        binding.tvITemTitle.text = item?.productName
        binding.tvITemDetail.text = item?.productDescription
        binding.tvITemDetailPrice.text = DecimalFormat("#,###").format(item?.price) + "원"



        binding.ivBack.setOnClickListener {
            exit()
        }


    }

    fun exit() {
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("itemIndex", itemPosition)
            putExtra("isLike", isLike)
        }
        setResult(RESULT_OK, intent)
        if (!isFinishing) finish()
    }

    override fun onBackPressed() {
        exit()
    }

}