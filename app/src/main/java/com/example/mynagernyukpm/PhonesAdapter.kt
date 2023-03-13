package com.example.mynagernyukpm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

private var mPhonesList: ArrayList<PhoneModel> = ArrayList()


fun setupPhones(phonesList: ArrayList<PhoneModel>){
    mPhonesList.clear()
    mPhonesList.addAll(phonesList)
    //notifyDataSetChanged()
}

class PhonesAdapter :RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.recyclerview_item, parent, false)
        return PhonesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is PhonesViewHolder){
            holder.bind(mPhones = mPhonesList[position])
        }
    }

    override fun getItemCount(): Int {
        return mPhonesList.count()
    }
}

class PhonesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    fun bind(mPhones: PhoneModel){
        itemView.textViewName.text = mPhones.name
        itemView.textViewPrice.text = mPhones.price
        itemView.textViewDate.text = mPhones.data
        itemView.textViewScore.text = mPhones.score
    }

}