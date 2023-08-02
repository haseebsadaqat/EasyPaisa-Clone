package com.example.task9kotlin.promotionsFragment


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.task9kotlin.databinding.DetailPromoFragViewBinding
import com.example.task9kotlin.databinding.FragmentPromotionsBinding
import com.example.task9kotlin.databinding.MainPromotionsRecDetailBinding

class PromoFragAdapter : RecyclerView.Adapter<PromoFragAdapter.MyViewHolder>() {
    private var imagesArray = arrayOf<Int>()
    fun setImagesIntergerArray(imagesList : Array<Int>){
        imagesArray = imagesList
        notifyDataSetChanged()
    }
    inner class MyViewHolder(val binding: DetailPromoFragViewBinding): RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val binding=DetailPromoFragViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }
    override fun getItemCount(): Int {
     return imagesArray.size
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.imagePromoFragRecycler.setImageResource(imagesArray[position])

    }


}