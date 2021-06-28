package br.edu.infnet.premiersoftchallenge.models

import br.edu.infnet.premiersoftchallenge.models.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)