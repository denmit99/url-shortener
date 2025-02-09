package com.denmit99.url_shortener.model.dto

import jakarta.validation.constraints.NotBlank

//TODO validate that string has URL format
data class ShortenRequestDTO(
    @field:NotBlank
    val url: String
)
