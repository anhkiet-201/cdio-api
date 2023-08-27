package com.anhkiet.cdio4_api.helper

import java.util.*

data class ResponseObject(
    var status: Int,
    var message: String,
    var objects: Any
)