package com.example.worksystem.service.impl;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiAttendanceListRequest;
import com.dingtalk.api.response.OapiAttendanceListResponse;
import com.example.worksystem.domain.PunchResult;
import com.example.worksystem.service.GetPunchResults;
import com.example.worksystem.service.TokenService;
import com.taobao.api.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import static com.example.worksystem.constant.UrlConstant.GET_Punch_Results;
public class GetPunchResultsImpl implements GetPunchResults {
    @Autowired
    private TokenService tokenService;

    @Override
    public PunchResult getPunchResultsImpl() throws ApiException {


        String access_token = tokenService.AccessToken();
        DingTalkClient clientDingTalkClient = new DefaultDingTalkClient(GET_Punch_Results);
        OapiAttendanceListRequest requestAttendanceListRequest = new OapiAttendanceListRequest();
        // 查询考勤打卡记录的起始工作日
        requestAttendanceListRequest.setWorkDateFrom("2021-01-12 00:00:00");
        // 查询考勤打卡记录的结束工作日
        requestAttendanceListRequest.setWorkDateTo("2021-01-19 00:00:00");
        // 员工在企业内的userid列表，最多不能超过50个。
        requestAttendanceListRequest.setUserIdList(Arrays.asList("10203029011219896"));
        // 表示获取考勤数据的起始点
        requestAttendanceListRequest.setOffset(0L);
        // 表示获取考勤数据的条数，最大不能超过50条。
        requestAttendanceListRequest.setLimit(1L);

        OapiAttendanceListResponse response = null;
        try {
            response = clientDingTalkClient.execute(requestAttendanceListRequest,access_token);
        } catch (ApiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



        return null;
    }
}
