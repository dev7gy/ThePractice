package com.msastudy.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController // 설정파일의 설정이 애플리케이션 재배포과정 없이 실시간으로 반영
public class ConfigClientController {
    @Value("${who.am.i}")
    private String identity;

    @RequestMapping("/")
    public String home() {
        return identity;
    }

}
