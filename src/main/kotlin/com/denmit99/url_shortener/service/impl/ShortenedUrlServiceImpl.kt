package com.denmit99.url_shortener.service.impl

import com.denmit99.url_shortener.model.entity.ShortenedUrl
import com.denmit99.url_shortener.repository.ShortenedUrlRepository
import com.denmit99.url_shortener.service.ShortenedUrlService
import com.denmit99.url_shortener.util.Base62Converter
import org.springframework.stereotype.Service
import java.time.ZonedDateTime

@Service
class ShortenedUrlServiceImpl(
    private val repository: ShortenedUrlRepository
) : ShortenedUrlService {
    override fun shorten(url: String): String {
        val entity = ShortenedUrl(originalUrl = url, creationDate = ZonedDateTime.now(), shortenedCode = "")
        val savedEntity = repository.save(entity)
        val shortenedCode = Base62Converter.decimalToBase62(savedEntity.id)
        savedEntity.shortenedCode = shortenedCode
        repository.save(savedEntity)
        return shortenedCode
    }
}