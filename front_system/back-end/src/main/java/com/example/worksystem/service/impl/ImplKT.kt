package com.example.worksystem.service.impl

import com.example.worksystem.domain.PunchResult
import com.example.worksystem.domain.Recordresult
import com.example.worksystem.domain.UserIdResult
import com.example.worksystem.mapper.TokenMapper
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ImplKT @Autowired constructor(
        val tokenMapper: TokenMapper,
) {
    fun getAccToken(CACHE_TTL:Long):String {
        val accTok = tokenMapper.selectById(1) ?: return ""
        return if (System.currentTimeMillis() - accTok.begintime!! <= CACHE_TTL) accTok.accesstoken!! else ""
    }

    fun getUserIDBody(userResBody: String) = Json.decodeFromString<UserIdResult>(userResBody)

    fun getPunch(punch:String) = Json.decodeFromString<PunchResult>(punch).recordresult
}