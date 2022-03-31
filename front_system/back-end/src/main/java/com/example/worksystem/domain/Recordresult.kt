package com.example.worksystem.domain

import kotlinx.serialization.Serializable

@Serializable
data class Recordresult(
        val sourceType:String,
        val baseCheckTime:Long,
        val userCheckTime:Long,
        val procInstId:String?=null,
        val approveId:String?=null,
        val locationResult:String,
        val timeResult:String,
        val checkType:String,
        val userId:String,
        val workDate:Long,
        val recordId:Long?=null,
        val planId:Long,
        val groupId:Long,
        val id:Long,
        val corpId:String?=null
)
