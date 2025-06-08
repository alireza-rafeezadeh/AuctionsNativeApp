package com.jetbrains.kmpapp.data

import kotlinx.serialization.Serializable

@Serializable
data class Image(
    val largeUrl: String,
    val thumbUrl: String
)