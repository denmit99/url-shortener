package com.denmit99.url_shortener.controller

import com.denmit99.url_shortener.model.dto.ShortenRequestDTO
import com.denmit99.url_shortener.model.dto.ShortenResponseDTO
import com.denmit99.url_shortener.service.ShortenedUrlService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ShortenedUrlController(
    private val shortenedUrlService: ShortenedUrlService
) {

    @PostMapping("/shorten")
    fun shorten(@RequestBody requestDTO: ShortenRequestDTO): ShortenResponseDTO {
        return ShortenResponseDTO(shortenedUrlService.shorten(requestDTO.url))
    }

    @GetMapping("/resolve")
    fun resolve() {
        //TODO
    }
}