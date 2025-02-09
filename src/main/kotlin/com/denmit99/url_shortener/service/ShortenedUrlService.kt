package com.denmit99.url_shortener.service

interface ShortenedUrlService {
    fun shorten(url: String): String
    fun resolve(code: String): String
}