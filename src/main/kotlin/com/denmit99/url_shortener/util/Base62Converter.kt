package com.denmit99.url_shortener.util

object Base62Converter {

    private const val ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

    fun decimalToBase62(value: Long): String {
        val res = StringBuilder()
        var valueTemp = value
        while (valueTemp != 0L) {
            res.append(ALPHABET[(valueTemp % 62).toInt()])
            valueTemp /= 62
        }
        return res.toString().reversed()
    }

    //TODO
    fun base62ToDecimal(value: String): Long {
        return 0L
    }
}