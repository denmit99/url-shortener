package com.denmit99.url_shortener.util

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Base62ConverterTest {
    @Test
    fun convertLessThan62() {
        assertEquals("9", Base62Converter.decimalToBase62(9L))
    }

    @Test
    fun convertGreaterThan62() {
        assertEquals("11", Base62Converter.decimalToBase62(63L))
    }

    @Test
    fun convertGreaterThan62WithLetters() {
        assertEquals("2b", Base62Converter.decimalToBase62(135L))
    }
}