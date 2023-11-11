package com.example.news_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news_api.Models.NewsModel
import com.example.news_api.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActtivity"
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var api = NewsClient.getNewsClient().create(NewsInterface::class.java)
        api.getNewsInterface("in","business","de9738db78ec41e0bcebc4d76be7060a")
            .enqueue(object  : Callback<NewsModel> {
                override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
                    var model = response.body()

                    var adapter = NewsAdapter(model?.articles)
                    binding.rcvNews.layoutManager = LinearLayoutManager(this@MainActivity)
                    binding.rcvNews.adapter = adapter
                }
                override fun onFailure(call: Call<NewsModel>, t: Throwable) {

                }
            })
    }
}