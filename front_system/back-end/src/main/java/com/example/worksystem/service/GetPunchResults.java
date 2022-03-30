package com.example.worksystem.service;

import com.example.worksystem.domain.PunchResult;
import com.taobao.api.ApiException;

public interface GetPunchResults {


    public PunchResult getPunchResultsImpl() throws ApiException;


}
