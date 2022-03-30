package com.example.worksystem.service.impl

import com.example.worksystem.mapper.TokenMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SelectToken {
    @Autowired
    lateinit var tokenMapper: TokenMapper

    fun getAccToken(CACHE_TTL:Long):String {
        val accTok = tokenMapper.selectById(1) ?: return ""
        return if (System.currentTimeMillis() - accTok.begintime!! <= CACHE_TTL) accTok.accesstoken!! else ""
    }
}