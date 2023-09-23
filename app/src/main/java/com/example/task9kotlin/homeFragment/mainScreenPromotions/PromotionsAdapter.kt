package com.example.task9kotlin.homeFragment.mainScreenPromotions
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.task9kotlin.R
import com.example.task9kotlin.databinding.MainPromotionsRecDetailBinding

class PromotionsAdapter : RecyclerView.Adapter<PromotionsAdapter.ViewHolder>() {
    private var imagesArray = arrayOf<Int>()
    fun setImagesList(imagesList : Array<Int>){
        imagesArray = imagesList
        notifyDataSetChanged()
    }
    inner class ViewHolder(val binding: MainPromotionsRecDetailBinding): RecyclerView.ViewHolder(binding.root){}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MainPromotionsRecDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
    override fun getItemCount(): Int {
        return imagesArray.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.promorecyclerImages.setImageResource(imagesArray[position])
    }
}