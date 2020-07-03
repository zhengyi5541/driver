package me.zhengjie.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Component
@Configuration
public class WeiXinConfig {

    @Value("${WeiXin.AppID}")
    private   String AppID;
    @Value("${WeiXin.AppSecret}")
    private   String AppSecret;
}
