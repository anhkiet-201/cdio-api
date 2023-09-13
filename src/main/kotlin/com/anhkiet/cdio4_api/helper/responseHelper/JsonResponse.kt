package com.anhkiet.cdio4_api.helper.responseHelper

import com.anhkiet.cdio4_api.model.BaseResponseModel
import com.anhkiet.cdio4_api.model.PageableResponseModel
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.util.*

data class JsonBuilder<T>(
        val status: Int,
        val body: BaseResponseModel<T>
)

fun <T> content(status: HttpStatus, data: T? = null): JsonBuilder<T> {
    return JsonBuilder(
            status.value(),
            BaseResponseModel(
                    Date().time,
                    status.value(),
                    status.reasonPhrase,
                    data
            )
    )
}

fun <T> content(data: T): JsonBuilder<T> = content(HttpStatus.OK, data)

fun <T> contentPageable(pageData: Page<T>, filterBy: ((T) -> Boolean)? = null): JsonBuilder<PageableResponseModel<T>> {
    var items = pageData.content
    filterBy?.let { filter ->
        items = items.filter {
            filter.invoke(it)
        }
    }
    return content(
            PageableResponseModel(
                    pageData.number,
                    pageData.totalPages,
                    pageData.hasNext(),
                    items
            )
    )
}

inline fun <T, E> T.response(contentBuilder: (T) -> JsonBuilder<E>): ResponseEntity<BaseResponseModel<E>> {
    val builder = contentBuilder.invoke(this)
    return ResponseEntity.status(builder.status).body(
            builder.body
    )
}
