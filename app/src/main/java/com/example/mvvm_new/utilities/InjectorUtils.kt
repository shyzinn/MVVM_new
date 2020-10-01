package com.example.mvvm_new.utilities

import com.example.mvvm_new.data.FakeDatabase
import com.example.mvvm_new.data.QuoteRepository
import com.example.mvvm_new.ui.quotes.QuotesViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        // ViewModelFactory needs a repository, which in turn needs a DAO from a database
        // The whole dependency tree is constructed right here, in one place
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}