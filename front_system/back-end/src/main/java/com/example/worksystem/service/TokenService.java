package com.example.worksystem.service;


import com.taobao.api.ApiException;

public interface TokenService
{
    public String AccessToken() throws ApiException;
    public String getNewAccessToken() throws ApiException;

}