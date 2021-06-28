package br.edu.infnet.premiersoftchallenge.repository

import br.edu.infnet.premiersoftchallenge.api.RetrofitInstance
import br.edu.infnet.premiersoftchallenge.db.ArticleDatabase

class NewsRepository(
    val db: ArticleDatabase

) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)
}
