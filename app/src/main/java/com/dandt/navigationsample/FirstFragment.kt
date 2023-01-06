package com.dandt.navigationsample

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.findFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dandt.navigationsample.adapter.NewsAdapter
import com.dandt.navigationsample.api.NewsApiClient
import com.dandt.navigationsample.data.ArticlesItem
import com.dandt.navigationsample.data.News
import com.dandt.navigationsample.databinding.FragmentFirstBinding
import com.dandt.navigationsample.viewmodel.NewsViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FirstFragment : Fragment() {

//    lateinit var news: News
    lateinit var _binding: FragmentFirstBinding
    lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        val view  = inflater.inflate(R.layout.fragment_first, container, false)

        _binding = FragmentFirstBinding.inflate(
            layoutInflater, container, false
        )

//        nextButton.setOnClickListener {
//            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment()
//
//            findNavController().navigate(action)
//        }
        newsAdapter = NewsAdapter()
//        _binding.recyclerView.layoutManager = LinearLayoutManager(context)
//        _binding.recyclerView.adapter = newsAdapter



        var newsViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)

        newsViewModel.getNews().observe(
            viewLifecycleOwner, Observer { news ->
                newsAdapter.updateArticleList(news.articles as List<ArticlesItem>)
                Log.d("ResponseViewModel->>>>>", news.articles.toString())
            }
        )
        _binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = newsAdapter
        }

        return _binding.root
    }
}