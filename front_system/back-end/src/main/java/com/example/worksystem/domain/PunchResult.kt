package com.example.worksystem.domain

import kotlinx.serialization.Serializable

@Serializable
data class PunchResult(
        val recordresult:List<com.example.worksystem.domain.Recordresult>,
        val hasMore:Boolean,
        val errmsg:String,
        val errcode:Int
)
