package com.example.latihanbunga.ui.dashboard
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.latihanbunga.app.ApiConfig
import com.example.latihanbunga.R
import com.example.latihanbunga.adapter.AdapterSekolah
import com.example.latihanbunga.model.SekolahModel
import com.example.latihanbunga.model.ResponseSekolah
import retrofit2.Call
import retrofit2.Response

class DashboardFragment : Fragment() {

    //
    lateinit var rvSekolah: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_dashboard, container, false)

        init(view)
        getSekolah()
        return view
    }

    private var listSekolah: ArrayList<SekolahModel> = ArrayList()

    fun getSekolah(){
        ApiConfig.instanceRetrofit.getSekolah().enqueue(object :
            retrofit2.Callback<ResponseSekolah> {

            override fun onResponse(call: Call<ResponseSekolah>, response: Response<ResponseSekolah>) {
                val res = response.body()!!
                listSekolah = res.sekolah
                DisplaySekolah()
            }
            override fun onFailure(call: Call<ResponseSekolah>, t: Throwable) {
                Toast.makeText(requireActivity(), "Error :"+t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    fun DisplaySekolah() {
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        rvSekolah.adapter = AdapterSekolah(requireActivity(), listSekolah)
        rvSekolah.layoutManager = layoutManager
    }

    fun init(view: View) {
        //rvBarang = view.findViewById(R.id.recyler_view)
        rvSekolah=view.findViewById(R.id.recyler_dashboard)
    }

}
