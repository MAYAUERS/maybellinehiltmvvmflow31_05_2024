package com.example.maybellinehiltmvvmflow31_05_2024.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.maybellinehiltmvvmflow31_05_2024.R
import com.example.maybellinehiltmvvmflow31_05_2024.model.MyblineData

import java.util.ArrayList

class MyblineItemAdapter(private var myblineData:ArrayList<MyblineData>):RecyclerView.Adapter<MyblineItemAdapter.MyViewHolder>() {

     class MyViewHolder( item: View):RecyclerView.ViewHolder(item) {
         var id =item.findViewById<TextView>(R.id.textView_id)
         var userName =item.findViewById<TextView>(R.id.textView_brand_name)
         var image = item.findViewById<ImageView>(R.id.image_data)

         fun bindView(myblineData: MyblineData){
             id.text= myblineData.id.toString()
             userName.text=myblineData.name
             val url = myblineData.image_link

            image.load(url)
         }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_user_item_list,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return myblineData.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.bindView(myblineData[position])
    }
}