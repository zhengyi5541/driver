package me.zhengjie.utils;

import me.zhengjie.config.WeiXinConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

@Component
public class WeiXinUtil {

    @Autowired
    private WeiXinConfig config;

    public String getOpenid(String code) throws Exception {
        String AppID = config.getAppID();
        String AppSecret=  config.getAppSecret();
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="
                + AppID + "&secret=" + AppSecret + "&js_code="
                + code + "&grant_type=authorization_code";
        URL reqURL = new URL(url);
        HttpsURLConnection openConnection = (HttpsURLConnection) reqURL
                .openConnection();
        openConnection.setConnectTimeout(10000);
        //这里我感觉获取openid的时间比较长，不过也可能是我网络的问题，
        //所以设置的响应时间比较长
        openConnection.connect();
        InputStream in = openConnection.getInputStream();

        StringBuilder builder = new StringBuilder();
        BufferedReader bufreader = new BufferedReader(new InputStreamReader(in));
        for (String temp = bufreader.readLine(); temp != null; temp = bufreader
                .readLine()) {
            builder.append(temp);
        }

        String result = builder.toString();
        in.close();
        openConnection.disconnect();
        return result;
        //result就是包含openid的键值对，返回给小程序前端即可
    }
}
