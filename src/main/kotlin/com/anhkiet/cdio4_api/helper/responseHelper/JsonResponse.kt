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

fun content(status: HttpStatus, message: String, vararg params: PairType): JsonBuilder {
    var map: Map<String, Any> = mapOf(
        "timestamp" to Date().time,
        "status" to status.value(),
        "message" to message
    )
    map = map.plus(params)
    return JsonBuilder(
        status.value(),
        map
    )
}

fun content(status: HttpStatus, vararg params: PairType): JsonBuilder {
    var map: Map<String, Any> = mapOf(
        "timestamp" to Date().time,
        "status" to status.value(),
    )
    map = map.plus(params)
    return JsonBuilder(
        status.value(),
        map
    )
}

inline fun <T> T.response(contentBuilder: (T) -> JsonBuilder): JsonResponseType {
    val builder = contentBuilder.invoke(this)
    return ResponseEntity.status(builder.status).body(
        builder.body
    )
}
