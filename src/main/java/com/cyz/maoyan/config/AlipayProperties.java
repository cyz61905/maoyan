package com.cyz.maoyan.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/9 下午4:24
 * @Version V1.0
 */

@Configuration
@Data
@ConfigurationProperties(prefix = "alipay.easy")
public class AlipayProperties {
    private String protocol;
    private String gatewayHost;
    private String signType;
    private String appId;
    private String merchantPrivateKey;
    private String alipayPublicKey;
    private String notifyUrl;
    private String encryptKey;
}
