package com.anhkiet.cdio4_api.dto

import com.anhkiet.cdio4_api.entities.Account
import com.anhkiet.cdio4_api.entities.News
import com.fasterxml.jackson.annotation.JsonIgnore
import java.math.BigDecimal
import java.util.*

data class NewsDTO(
    val newsId: Int,

    val title: String,

    val content: String,

    val account: Account? = null
) {
    var createTime: BigDecimal = BigDecimal(Date().time)

    constructor(news: News) : this(
        newsId = news.newsId,
        title = news.title,
        content = news.content,
        account = news.account
    ) {
        createTime = news.createTime
    }

    fun toEntity(): News {
        val news = News()
        news.newsId = newsId
        news.createTime = createTime
        news.content = content
        news.account = account
        return news
    }
}
