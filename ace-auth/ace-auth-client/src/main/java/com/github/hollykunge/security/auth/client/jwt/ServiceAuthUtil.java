
package com.github.hollykunge.security.auth.client.jwt;

import com.github.hollykunge.security.auth.client.config.ServiceAuthConfig;
import com.github.hollykunge.security.auth.client.feign.ServiceAuthFeign;
import com.github.hollykunge.security.auth.common.util.jwt.IJWTInfo;
import com.github.hollykunge.security.auth.common.util.jwt.JWTHelper;
import com.github.hollykunge.security.common.exception.auth.ClientTokenException;
import com.github.hollykunge.security.common.msg.BaseResponse;
import com.github.hollykunge.security.common.msg.ObjectRestResponse;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

/**
 * jwt申请服务
 * Created by 协同设计小组 on 2017/9/15.
 */
@Configuration
@Slf4j
@EnableScheduling
public class ServiceAuthUtil{
    @Autowired
    private ServiceAuthConfig serviceAuthConfig;

    @Autowired
    private ServiceAuthFeign serviceAuthFeign;

    private List<String> allowedClient;
    private String clientToken;


    public IJWTInfo getInfoFromToken(String token) throws Exception {
        try {
            return JWTHelper.getInfoFromToken(token, serviceAuthConfig.getPubKeyByte());
        } catch (ExpiredJwtException ex) {
            throw new ClientTokenException("Client token expired!");
        } catch (SignatureException ex) {
            throw new ClientTokenException("Client token signature error!");
        } catch (IllegalArgumentException ex) {
            throw new ClientTokenException("Client token is null or empty!");
        }
    }

    /**
     * 定时刷新可访问的服务列表，每30分钟触发一次
     */
    @Scheduled(cron = "0/30 * * * * ?")
    public void refreshAllowedClient() {
        log.debug("refresh allowedClient.....");
        BaseResponse resp = serviceAuthFeign.getAllowedClient(serviceAuthConfig.getClientId(), serviceAuthConfig.getClientSecret());
        if (resp.getStatus() == 200) {
            ObjectRestResponse<List<String>> allowedClient = (ObjectRestResponse<List<String>>) resp;
            this.allowedClient = allowedClient.getData();
        }
    }
    /**
     * 定时刷新可访问的服务JWT，每10分钟触发一次
     */
    @Scheduled(cron = "0 0/10 * * * ?")
    public void refreshClientToken() {
        log.debug("refresh client token.....");
        BaseResponse resp = serviceAuthFeign.getAccessToken(serviceAuthConfig.getClientId(), serviceAuthConfig.getClientSecret());
        if (resp.getStatus() == 200) {
            ObjectRestResponse<String> clientToken = (ObjectRestResponse<String>) resp;
            this.clientToken = clientToken.getData();
        }
    }


    public String getClientToken() {
        if (this.clientToken == null) {
            this.refreshClientToken();
        }
        return clientToken;
    }

    public List<String> getAllowedClient() {
        if (this.allowedClient == null) {
            this.refreshAllowedClient();
        }
        return allowedClient;
    }
}