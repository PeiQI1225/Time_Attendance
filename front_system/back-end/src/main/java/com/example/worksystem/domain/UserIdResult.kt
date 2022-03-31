package com.example.worksystem.domain

import kotlinx.serialization.*

@Serializable
data class UserIdResult(
        val result: com.example.worksystem.domain.Result,
        val errcode: Int,
        val errmsg:String,
        val success:Boolean,
        val request_id: String
)