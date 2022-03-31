package com.example.worksystem.service;

import com.example.worksystem.domain.Recordresult;
import com.taobao.api.ApiException;

import java.util.List;

public interface GetPunchResults {


    public List<Recordresult> getPunchResultsImpl() throws ApiException;


}
