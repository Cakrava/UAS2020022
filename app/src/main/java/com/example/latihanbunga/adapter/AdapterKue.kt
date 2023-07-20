package com.example.latihanbunga.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.latihanbunga.R
import com.example.latihanbunga.model.KueModel
import kotlin.collections.ArrayList

class AdapterKue(var activity: Activity, var data: ArrayList<KueModel>): RecyclerView.Adapter<AdapterKue.Holder>() {
    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val kdkue = view.findViewById<TextView>(R.id.kdkue)
        val nama_kue = view.findViewById<TextView>(R.id.nama_kue)
        val jenis = view.findViewById<TextView>(R.id.jenis)
        val harga = view.findViewById<TextView>(R.id.harga)
        val jumlah = view.findViewById<TextView>(R.id.jumlah)
        val foto_kue = view.findViewById<ImageView>(R.id.foto_kue)
    }

    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        context = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.kue, parent, false)
        return Holder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val a = data[position]
        holder.kdkue.text = a.kdkue.toString()
        holder.nama_kue.text = a.nama_kue
        holder.jenis.text = a.jenis
        holder.harga.text = a.harga.toString()
        holder.jumlah.text = a.jumlah.toString()


        // Menampilkan gambar menggunakan Glide
        Glide.with(context)
            .load("http://192.168.135.245/laravel_1/storage/app/public/${a.foto_kue}")
            .into(holder.foto_kue)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
