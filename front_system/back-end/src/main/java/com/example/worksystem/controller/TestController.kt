package com.example.worksystem.controller

import com.example.worksystem.domain.ServiceResult
import com.example.worksystem.mapper.TokenMapper
import com.example.worksystem.service.TokenService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {
    @Autowired
    lateinit var tokenService: TokenService
    @GetMapping("/")
    fun test() = ServiceResult.success(tokenService.AccessToken())
}
