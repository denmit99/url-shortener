package com.denmit99.url_shortener.service.impl

import com.denmit99.url_shortener.exception.NotFoundException
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
        val entity = ShortenedUrl(originalUrl = url, creationDate = ZonedDateTime.now(), code = "")
        val savedEntity = repository.save(entity)
        val code = Base62Converter.decimalToBase62(savedEntity.id)
        savedEntity.code = code
        repository.save(savedEntity)
        return code
    }

    override fun resolve(code: String): String {
        return repository.findByCode(code)?.originalUrl
            ?: throw NotFoundException("URL for code '$code' not found")
    }
}