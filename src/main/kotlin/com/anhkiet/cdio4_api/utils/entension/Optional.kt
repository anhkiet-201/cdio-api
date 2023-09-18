package com.anhkiet.cdio4_api.utils.entension

import java.util.*

fun <T> Optional<T>.toNullSafe(): T? = if (this.isEmpty) null else this.get()