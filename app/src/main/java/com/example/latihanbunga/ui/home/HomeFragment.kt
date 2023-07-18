package com.example.latihanbunga.ui.home
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
import com.example.latihanbunga.adapter.AdapterBunga
import com.example.latihanbunga.model.BungaModel
import com.example.latihanbunga.model.ResponseModel
import retrofit2.Call
import retrofit2.Response

class HomeFragment : Fragment() {

    //
    lateinit var rvBunga: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        init(view)
        getBunga()
        return view
    }

    private var listBunga: ArrayList<BungaModel> = ArrayList()

    fun getBunga(){
        ApiConfig.instanceRetrofit.getBunga().enqueue(object :
            retrofit2.Callback<ResponseModel> {

            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                val res = response.body()!!
                listBunga = res.bunga
                displayBunga()
            }
            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                Toast.makeText(requireActivity(), "Error :"+t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    fun displayBunga() {
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        rvBunga.adapter = AdapterBunga(requireActivity(), listBunga)
        rvBunga.layoutManager = layoutManager
    }

    fun init(view: View) {
        //rvBarang = view.findViewById(R.id.recyler_view)
        rvBunga=view.findViewById(R.id.recyler_view)
    }

}
