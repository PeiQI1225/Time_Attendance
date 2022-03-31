package com.example.worksystem.service;
import com.taobao.api.ApiException;

import java.util.List;

public interface GetUserId
{
    public List<String> getUserIdImpl() throws ApiException;

}
