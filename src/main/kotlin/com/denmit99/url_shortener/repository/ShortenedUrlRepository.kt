package com.denmit99.url_shortener.repository

import com.denmit99.url_shortener.model.entity.ShortenedUrl
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ShortenedUrlRepository: JpaRepository<ShortenedUrl, Long>