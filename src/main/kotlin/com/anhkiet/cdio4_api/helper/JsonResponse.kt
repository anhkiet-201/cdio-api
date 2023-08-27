package com.anhkiet.cdio4_api.helper

import org.springframework.http.ResponseEntity

typealias JsonResponseType = ResponseEntity<Map<String, Any?>>
typealias PairType = Pair<String, Any>

class ResponseBuilder(private var status: Int, private var message: String, vararg params: PairType = emptyArray()) {

    private var params: List<PairType>

    init {
        this.params = params.toList()
    }

    companion object {
        const val OK = 200
        const val CREATED = 201
        const val NO_CONTENT = 204
        const val BAD_REQUEST = 400
        const val UNAUTHORIZED = 401
        const val NOT_FOUND = 404
    }

    fun toResponse(): JsonResponseType {
        var map: Map<String, Any> = mapOf(
            "status" to status,
            "message" to message,
        )
        map = map.plus(params)
        return ResponseEntity.status(status).body(
            map
        )
    }
}

inline fun <T> T.response(success: (T) -> ResponseBuilder, error: () -> ResponseBuilder): JsonResponseType {
    return when (this) {
        null -> error()
        else -> success(this)
    }.toResponse()
}

infix fun <T> T.responseCustom(builder: (T) -> ResponseBuilder): JsonResponseType {
    return builder(this).toResponse()
}