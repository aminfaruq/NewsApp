package co.id.aminfaruq.newsapp.repository

import co.id.aminfaruq.newsapp.api.RetrofitInstance
import co.id.aminfaruq.newsapp.db.ArticleDatabase
import co.id.aminfaruq.newsapp.models.Article

class NewsRepository(
    val db: ArticleDatabase
) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article : Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getArticles()

    suspend fun deleteArticle(article : Article) = db.getArticleDao().deleteArticle(article)
}