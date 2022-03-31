package com.example.worksystem.constant;

/**
 * 钉钉开放接口网关常量
 */


public class UrlConstant {
    private static final String HOST = "https://oapi.dingtalk.com";
    /**
     * 获取access_token url
     */
    public static final String GET_ACCESS_TOKEN_URL = HOST + "/gettoken";
    public static final String GET_Punch_Results = HOST + "/attendance/list";
    public static final String GEt_User_ID = HOST + "/topapi/smartwork/hrm/employee/queryonjob";
}
