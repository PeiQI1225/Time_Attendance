package com.example.worksystem.domain;

import java.io.Serializable;
import java.util.List;

public class UserIdResuit<T> implements Serializable
{
    private List<T>  useridlist;
    private Number nextcursor;
    private Number errcode;
    private String errmsg;
    private Boolean success;
    private String requestid;


}
