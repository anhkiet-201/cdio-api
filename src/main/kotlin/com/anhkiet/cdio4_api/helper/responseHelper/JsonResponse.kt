package com.anhkiet.cdio4_api.helper.responseHelper

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.util.Calendar
import java.util.Date

typealias JsonResponseType = ResponseEntity<Map<String, Any?>>
typealias PairType = Pair<String, Any>
data class JsonBuilder(
    val status: Int,
    val body: Map<String, Any>
)

fun objectOf(vararg params: PairType): Map<String, Any> {
    return mapOf(*params)
}

fun content(status: HttpStatus, vararg params: PairType): JsonBuilder {
    val map: Map<String, Any> = mapOf(
        "timestamp" to Date().time,
        "status_code" to status.value(),
        "status_description" to status.reasonPhrase,
        "data" to objectOf(*params)
    )
    return JsonBuilder(
        status.value(),
        map
    )
}

fun content(vararg params: PairType): JsonBuilder = content(HttpStatus.OK, *params)

inline fun <T> T.response(contentBuilder: (T) -> JsonBuilder): JsonResponseType {
    val builder = contentBuilder.invoke(this)
    return ResponseEntity.status(builder.status).body(
        builder.body
    )
}
