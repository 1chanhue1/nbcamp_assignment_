package com.chanhue.nbcamp_assignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chanhue.nbcamp_assignment.databinding.ItemRecyclerviewBinding
import java.text.DecimalFormat

class MyAdapter(val mItems: MutableList<MyItem>) : RecyclerView.Adapter<MyAdapter.Holder>() {

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =
            ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {  //클릭이벤트추가부분
            itemClick?.onClick(it, position)
        }
        holder.iconImageView.setImageResource(mItems[position].imageFileName)
        holder.productName.text = mItems[position].productName
        holder.address.text = mItems[position].address

        val price = mItems[position].price
        holder.price.text = DecimalFormat("#,###").format(price) + "원"

        holder.chatCount.text = mItems[position].chatCount.toString()
        holder.likes.text = mItems[position].likes.toString()

       holder.ivAdapterLike.setImageResource(R.drawable.img_like)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    inner class Holder(val binding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val iconImageView = binding.iconItem
        val productName = binding.productName
        val address = binding.address
        val price = binding.price
        val chatCount = binding.chatCount
        val likes = binding.likes
        val ivAdapterLike = binding.ivLike


    }
}