package co.id.aminfaruq.newsapp.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.id.aminfaruq.newsapp.repository.NewsRepository

class NewsViewModelProviderFactory(
    val application: Application,
    val newsRepository: NewsRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(application, newsRepository) as T
    }
}