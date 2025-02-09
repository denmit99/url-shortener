package com.denmit99.url_shortener.model.entity

import jakarta.persistence.*
import java.time.ZonedDateTime

@Entity
@Table(name = "shortened_url")
data class ShortenedUrl(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long = 0,

    @Column(name = "original_url")
    val originalUrl: String,

    @Column(name = "shortened_code")
    var shortenedCode: String,

    @Column(name = "creation_date")
    val creationDate: ZonedDateTime

)
