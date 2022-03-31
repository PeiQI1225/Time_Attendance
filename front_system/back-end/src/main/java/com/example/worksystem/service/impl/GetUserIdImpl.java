package com.example.worksystem.service.impl;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiSmartworkHrmEmployeeQueryonjobRequest;
import com.dingtalk.api.response.OapiSmartworkHrmEmployeeQueryonjobResponse;
import com.example.worksystem.service.GetUserId;
import com.example.worksystem.service.TokenService;
import com.taobao.api.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.worksystem.constant.UrlConstant.GEt_User_ID;

@Service
public class GetUserIdImpl implements GetUserId
{
    @Autowired
    private TokenService tokenService;
    @Autowired
    private ImplKT implKT;

    @Override
    public List<String> getUserIdImpl() throws ApiException {
        String access_token = tokenService.AccessToken();
        DingTalkClient client = new DefaultDingTalkClient(GEt_User_ID);
        OapiSmartworkHrmEmployeeQueryonjobRequest req = new OapiSmartworkHrmEmployeeQueryonjobRequest();
        req.setStatusList("2,3,5,-1");
        req.setOffset(0L);
        req.setSize(50L);
        OapiSmartworkHrmEmployeeQueryonjobResponse rsp = client.execute(req, access_token);

        return implKT.getUserIDBody(rsp.getBody()).getResult().getData_list();
    }
}
