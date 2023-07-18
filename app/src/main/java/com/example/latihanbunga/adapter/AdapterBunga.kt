package com.example.latihanbunga.adapter
import android.annotation. SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


import com.example.latihanbunga.R
import com.example.latihanbunga.model.BungaModel
import kotlin.collections.ArrayList

// fungsi variabel di kiri hanya deklarasi, variabel di kanan berasal dari xml
class AdapterBunga (var activity: Activity, var data: ArrayList<BungaModel>): RecyclerView.Adapter<AdapterBunga.Holder>() {
    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNama = view.findViewById<TextView>(R.id.tvnama)
        val tvJenis = view.findViewById<TextView>(R.id.tvjenis)
        val tvHarga = view.findViewById<TextView>(R.id.tvharga)


    }

    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        context = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.bunga, parent, false)
        return Holder(view)
    }

    // fungsi variabel di kiri hasil deklarasi diatas, variabel dikanan berasal dari ModelKaryawan
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val a = data[position]
        holder.tvNama.text = a.nama
        holder.tvJenis.text = a.jenis
        holder.tvHarga.text = a.harga


    }

    override fun getItemCount(): Int {
        return data.size
    }
}
