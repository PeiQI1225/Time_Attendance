package com.example.worksystem.controller

import com.example.worksystem.domain.ServiceResult
import com.example.worksystem.mapper.TokenMapper
import com.example.worksystem.service.GetPunchResults
import com.example.worksystem.service.GetUserId
import com.example.worksystem.service.TokenService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController @Autowired constructor(
        private val tokenService: TokenService,
        private val getUserId: GetUserId,
        val getPunchResults: GetPunchResults
) {
    @GetMapping("/")
    fun test() = ServiceResult.success(tokenService.AccessToken())
    @GetMapping("/id")
    fun test1() = getUserId.userIdImpl
    @GetMapping("/res")
    fun test2() = getPunchResults.punchResultsImpl
}
