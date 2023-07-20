package com.example.latihanbunga.ui.notifications
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
import com.example.latihanbunga.adapter.AdapterKue
import com.example.latihanbunga.model.KueModel
import com.example.latihanbunga.model.ResponseKue
import retrofit2.Call
import retrofit2.Response

class NotificationsFragment : Fragment() {

    //
    lateinit var rvKue: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_notifications, container, false)

        init(view)
        getKue()
        return view
    }

    private var listKue: ArrayList<KueModel> = ArrayList()

    fun getKue(){
        ApiConfig.instanceRetrofit.getKue().enqueue(object :
            retrofit2.Callback<ResponseKue> {

            override fun onResponse(call: Call<ResponseKue>, response: Response<ResponseKue>) {
                val res = response.body()!!
                listKue = res.kue
                DisplayKue()
            }
            override fun onFailure(call: Call<ResponseKue>, t: Throwable) {
                Toast.makeText(requireActivity(), "Error :"+t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    fun DisplayKue() {
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        rvKue.adapter = AdapterKue(requireActivity(), listKue)
        rvKue.layoutManager = layoutManager
    }

    fun init(view: View) {
        rvKue=view.findViewById(R.id.recyler_notifikasi)
    }

}
