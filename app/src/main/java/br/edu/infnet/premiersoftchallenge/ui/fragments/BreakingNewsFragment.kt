package br.edu.infnet.premiersoftchallenge.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.infnet.premiersoftchallenge.R
import br.edu.infnet.premiersoftchallenge.adapters.NewsAdapter
import br.edu.infnet.premiersoftchallenge.models.NewsResponse
import br.edu.infnet.premiersoftchallenge.ui.NewsActivity
import br.edu.infnet.premiersoftchallenge.ui.NewsViewModel
import br.edu.infnet.premiersoftchallenge.util.Resource
import kotlinx.android.synthetic.main.fragment_breaking_news.*

class BreakingNewsFragment: Fragment(R.layout.fragment_breaking_news) {

    lateinit var  viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter

    val TAG = "BreakNewsFragment"


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel

        setupRecycleView()

        viewModel.breakingNews.observe(viewLifecycleOwner, Observer {
            response ->
            when (response){
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let {
                        newsResponse -> newsAdapter.differ.submitList(newsResponse.articles)
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let { message ->
                        Log.e(TAG, "Ocorreu um erro: $message")
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        })
    }

    private fun hideProgressBar() {
        paginationProgressBar.visibility = View.INVISIBLE
    }
    private fun showProgressBar (){
        paginationProgressBar.visibility = View.VISIBLE
    }

    private fun setupRecycleView(){
        newsAdapter = NewsAdapter()
        rvBreakingNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}