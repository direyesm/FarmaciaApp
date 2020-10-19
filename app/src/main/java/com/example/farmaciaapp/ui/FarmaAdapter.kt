package com.example.farmaciaapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.farmaciaapp.R
import com.example.farmaciaapp.model.local.FarmaciaEntity
import kotlinx.android.synthetic.main.farma_item_list.view.*

class FarmaAdapter(var mFarma: FarmaSet) :RecyclerView.Adapter<FarmaAdapter.FarmaciasViewHolder>() {

    private var farmaList = emptyList<FarmaciaEntity>()

    fun updateAdapter(mList : List<FarmaciaEntity>){
        farmaList = mList
        notifyDataSetChanged()
    }

    inner class FarmaciasViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val id = itemView.txtLocal
        val name = itemView.txtName
        val comuna = itemView.txtComuna
        val direccion = itemView.txtDirec

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FarmaciasViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.farma_item_list, parent, false)
        return FarmaciasViewHolder(view)
    }

    override fun onBindViewHolder(holder: FarmaciasViewHolder, position: Int) {
        val drugs = farmaList[position]
        holder.id.text = drugs.id
        holder.name.text = drugs.Nombre
        holder.comuna.text = drugs.Comuna
        holder.direccion.text = drugs.Direccion
    }

    override fun getItemCount() = farmaList.size

    interface FarmaSet{
        fun passFarmaSet(mFarma: FarmaciaEntity)
    }
}