package com.cyz.maoyan.config;

import com.alipay.easysdk.kernel.Config;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/9 下午4:29
 * @Version V1.0
 */

@Configuration
@Data
public class AlipayConfig {
    @Bean
    public Config config(AlipayProperties alipayProperties) {
        Config config = new Config();
        config.protocol = alipayProperties.getProtocol();
        config.gatewayHost = alipayProperties.getGatewayHost();
        config.signType = alipayProperties.getSignType();
        config.appId = alipayProperties.getAppId();
        config.merchantPrivateKey = alipayProperties.getMerchantPrivateKey();
        config.alipayPublicKey = alipayProperties.getAlipayPublicKey();
        config.notifyUrl = alipayProperties.getNotifyUrl();
        config.encryptKey = alipayProperties.getEncryptKey();
        return config;
    }
}
