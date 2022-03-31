package com.example.worksystem.service.impl;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiAttendanceListRequest;
import com.dingtalk.api.response.OapiAttendanceListResponse;
import com.example.worksystem.domain.Recordresult;
import com.example.worksystem.service.GetPunchResults;
import com.example.worksystem.service.GetUserId;
import com.example.worksystem.service.TokenService;
import com.taobao.api.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.worksystem.constant.UrlConstant.GET_Punch_Results;
@Service
public class GetPunchResultsImpl implements GetPunchResults {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private GetUserId getUserId;
    @Autowired
    private ImplKT implKT;
    @Override
    public List<Recordresult> getPunchResultsImpl() throws ApiException {


        String access_token = tokenService.AccessToken();
        DingTalkClient clientDingTalkClient = new DefaultDingTalkClient(GET_Punch_Results);
        OapiAttendanceListRequest requestAttendanceListRequest = new OapiAttendanceListRequest();
        // 查询考勤打卡记录的起始工作日
        requestAttendanceListRequest.setWorkDateFrom("2022-03-28 00:00:00");
        // 查询考勤打卡记录的结束工作日
        requestAttendanceListRequest.setWorkDateTo("2022-03-31 00:00:00");
        // 员工在企业内的userid列表，最多不能超过50个。

        requestAttendanceListRequest.setUserIdList(getUserId.getUserIdImpl());
        // 表示获取考勤数据的起始点
        requestAttendanceListRequest.setOffset(0L);
        // 表示获取考勤数据的条数，最大不能超过50条。
        requestAttendanceListRequest.setLimit(50L);

        OapiAttendanceListResponse response = null;
        try {
            response = clientDingTalkClient.execute(requestAttendanceListRequest,access_token);
        } catch (ApiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



        return implKT.getPunch(response.getBody());
    }
}
