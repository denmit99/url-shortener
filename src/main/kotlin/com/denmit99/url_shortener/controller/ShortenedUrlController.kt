package com.denmit99.url_shortener.controller

import com.denmit99.url_shortener.model.dto.ResolveResponseDTO
import com.denmit99.url_shortener.model.dto.ShortenRequestDTO
import com.denmit99.url_shortener.model.dto.ShortenResponseDTO
import com.denmit99.url_shortener.service.ShortenedUrlService
import org.springframework.web.bind.annotation.*

@RestController
class ShortenedUrlController(
    private val shortenedUrlService: ShortenedUrlService
) {

    @PostMapping("/shorten")
    fun shorten(@RequestBody requestDTO: ShortenRequestDTO): ShortenResponseDTO {
        return ShortenResponseDTO(shortenedUrlService.shorten(requestDTO.url))
    }

    @GetMapping("/resolve")
    fun resolve(@RequestParam code: String): ResolveResponseDTO {
        return ResolveResponseDTO(shortenedUrlService.resolve(code))
    }
}