package com.justcs.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 自定义上传文件配置类
 */
@Component
@ConfigurationProperties(prefix = "voiceupload")
public class UploadFileConfig {

    // 临时文件的地址
    private String basetemp;

    public String getBasetemp() {
        return basetemp;
    }

    public void setBasetemp(String basetemp) {
        this.basetemp = basetemp;
    }
}
