package com.denmit99.url_shortener.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory

object Base62Converter {

    private const val ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

    private val logger: Logger = LoggerFactory.getLogger(Base62Converter::class.java)

    fun decimalToBase62(value: Long): String {
        logger.debug("Converting $value to base62 started")
        val str = StringBuilder()
        var valueTemp = value
        while (valueTemp != 0L) {
            str.append(ALPHABET[(valueTemp % 62).toInt()])
            valueTemp /= 62
        }
        val res = str.toString().reversed()
        logger.debug("Converting $value to base62 finished. Result: $res")
        return res
    }

}