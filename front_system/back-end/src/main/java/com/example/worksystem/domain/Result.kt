package com.example.worksystem.domain

import kotlinx.serialization.Serializable


@Serializable
data class Result(
    val data_list:List<String>,
    val next_cursor:Int?=null
)
