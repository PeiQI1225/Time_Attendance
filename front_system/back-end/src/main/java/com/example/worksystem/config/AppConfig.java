package com.example.worksystem.config;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Data
@Configuration
public class AppConfig {
    @Value("${dingtalk.app_key}")
    private String appKey;

    @Value("${dingtalk.app_secret}")
    private String appSecret;

    @Value("${dingtalk.corp_id}")
    private String corpId;

    @Value("${dingtalk.agent_id}")
    private Long agentId;






}
