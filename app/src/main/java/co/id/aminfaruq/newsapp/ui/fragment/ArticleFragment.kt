package co.id.aminfaruq.newsapp.ui.fragment

import android.os.Bundle
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import co.id.aminfaruq.newsapp.R
import co.id.aminfaruq.newsapp.ui.NewsActivity
import co.id.aminfaruq.newsapp.ui.NewsViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleFragment : Fragment(R.layout.fragment_article) {

    lateinit var viewModel: NewsViewModel
    val args: ArticleFragmentArgs by navArgs()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        val article = args.article

        webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
        }

        fab.setOnClickListener {
            viewModel.saveArticle(article)
            view?.let { it1 -> Snackbar.make(it1, "Article saved successfully" , Snackbar.LENGTH_SHORT).show() }
        }
    }
}