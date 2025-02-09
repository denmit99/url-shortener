package com.denmit99.url_shortener.controller

import com.denmit99.url_shortener.model.dto.ResolveResponseDTO
import com.denmit99.url_shortener.model.dto.ShortenRequestDTO
import com.denmit99.url_shortener.model.dto.ShortenResponseDTO
import com.denmit99.url_shortener.service.ShortenedUrlService
import jakarta.validation.Valid
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
class ShortenedUrlController(
    private val shortenedUrlService: ShortenedUrlService
) {

    private val logger: Logger = LoggerFactory.getLogger(ShortenedUrlController::class.java)

    @PostMapping("/shorten")
    fun shorten(@RequestBody @Valid requestDTO: ShortenRequestDTO): ShortenResponseDTO {
        logger.info("Received request to /shorten, URL: ${requestDTO.url}")
        val res = shortenedUrlService.shorten(requestDTO.url)
        logger.info("Assigned code $res")
        return ShortenResponseDTO(res)
    }

    @GetMapping("/resolve")
    fun resolve(@RequestParam code: String): ResolveResponseDTO {
        logger.info("Received request to /resolve, code: $code")
        val res = shortenedUrlService.resolve(code)
        logger.info("Found URL: $res")
        return ResolveResponseDTO(res)
    }
}