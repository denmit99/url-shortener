package com.denmit99.url_shortener.service.impl

import com.denmit99.url_shortener.exception.NotFoundException
import com.denmit99.url_shortener.model.entity.ShortenedUrl
import com.denmit99.url_shortener.repository.ShortenedUrlRepository
import com.denmit99.url_shortener.service.ShortenedUrlService
import com.denmit99.url_shortener.util.Base62Converter
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.ZonedDateTime

@Service
class ShortenedUrlServiceImpl(
    private val repository: ShortenedUrlRepository
) : ShortenedUrlService {

    private val logger: Logger = LoggerFactory.getLogger(ShortenedUrlServiceImpl::class.java)

    override fun shorten(url: String): String {
        logger.info("Start shortening URL: $url")
        val entity = ShortenedUrl(originalUrl = url, creationDate = ZonedDateTime.now(), code = "")
        val savedEntity = repository.save(entity)
        logger.debug("Shortened URL entity created: {}", savedEntity)
        val code = Base62Converter.decimalToBase62(savedEntity.id)
        savedEntity.code = code
        repository.save(savedEntity)
        logger.debug("Shortened URL entity updated")
        logger.info("Finish shortening URL: $url. Code: $code")
        return code
    }

    override fun resolve(code: String): String {
        logger.info("Start resolving code: $code")
        val res = repository.findByCode(code)?.originalUrl
            ?: throw NotFoundException("URL for code '$code' not found")
        logger.info("Finish resolving code: $code. URL: $res")
        return res
    }
}