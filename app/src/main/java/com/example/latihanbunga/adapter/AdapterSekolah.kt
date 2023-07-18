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
import com.example.latihanbunga.model.SekolahModel
import kotlin.collections.ArrayList

class AdapterSekolah(var activity: Activity, var data: ArrayList<SekolahModel>): RecyclerView.Adapter<AdapterSekolah.Holder>() {
    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val kdsekolah = view.findViewById<TextView>(R.id.kdsekolah)
        val nama_sekolah = view.findViewById<TextView>(R.id.nama_sekolah)
        val alamat = view.findViewById<TextView>(R.id.alamat)
        val uang_masuk = view.findViewById<TextView>(R.id.uang_masuk)
        val foto = view.findViewById<ImageView>(R.id.foto)
    }

    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        context = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.sekolah, parent, false)
        return Holder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val a = data[position]
        holder.uang_masuk.text = a.uang_masuk
        holder.alamat.text = a.alamat
        holder.nama_sekolah.text = a.nama_sekolah
        holder.kdsekolah.text = a.kdsekolah.toString()

        // Menampilkan gambar menggunakan Glide
        Glide.with(context)
            .load("http://10.234.150.35/laravel_1/storage/app/public/${a.foto}")
            .into(holder.foto)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
