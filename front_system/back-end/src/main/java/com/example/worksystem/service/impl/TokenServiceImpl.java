package com.example.worksystem.service.impl;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.example.worksystem.domain.Token;
import com.example.worksystem.mapper.TokenMapper;
import com.example.worksystem.service.TokenService;
import com.taobao.api.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.worksystem.config.AppConfig;

import static com.example.worksystem.constant.UrlConstant.GET_ACCESS_TOKEN_URL;


@Service
public class TokenServiceImpl implements TokenService {

    /**
     * 缓存时间：一小时50分钟
     */
    private static final long CACHE_TTL = 60 * 55 * 2 * 1000;


    @Autowired
    private TokenMapper tokenMapper;

    private final AppConfig appConfig;
    @Autowired
    private ImplKT implKT;

    @Autowired
    public TokenServiceImpl(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @Override
    public String AccessToken() throws ApiException {
//        try {
//            Token accessToken = tokenMapper.selectById(1);
//            if (accessToken.getAccesstoken() != null && System.currentTimeMillis() - accessToken.getBegintime() <= CACHE_TTL) {
//                return ServiceResult.success(accessToken.getAccesstoken());
//            }
//        }catch (Exception ignored){
//        }
        String accessToken = implKT.getAccToken(CACHE_TTL);
        if (accessToken.equals("")) accessToken = getNewAccessToken();
        return accessToken;

    }

    @Override
    public String getNewAccessToken() throws ApiException {
        DefaultDingTalkClient client = new DefaultDingTalkClient(GET_ACCESS_TOKEN_URL);
        OapiGettokenRequest request = new OapiGettokenRequest();
        OapiGettokenResponse response;

        request.setAppkey(appConfig.getAppKey());
        request.setAppsecret(appConfig.getAppSecret());
        request.setHttpMethod("GET");

        //    try {
        response = client.execute(request);
        //    } catch (ApiException e) {
        ////            log.error("getAccessToken failed", e);
        //        return ServiceResult.failure(e.getErrCode(), e.getErrMsg());
        //    }

        String newAccessToken = response.getAccessToken();
        tokenMapper.updateById(new Token(1, newAccessToken, System.currentTimeMillis()));
        return newAccessToken;
    }
}
