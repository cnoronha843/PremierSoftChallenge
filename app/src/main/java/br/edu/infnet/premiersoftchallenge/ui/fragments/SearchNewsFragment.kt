package br.edu.infnet.premiersoftchallenge.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import br.edu.infnet.premiersoftchallenge.R
import br.edu.infnet.premiersoftchallenge.ui.NewsActivity
import br.edu.infnet.premiersoftchallenge.ui.NewsViewModel

class SearchNewsFragment: Fragment(R.layout.fragment_search_news) {

    lateinit var viewModel: NewsViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
    }
}