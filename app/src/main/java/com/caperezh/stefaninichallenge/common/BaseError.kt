package com.caperezh.stefaninichallenge.common

data class BaseError(
    var cause: String = "Error en la conexión",
    var code: Int = -400,
    var exception: Exception? = null
)