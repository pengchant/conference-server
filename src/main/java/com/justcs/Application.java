package com.justcs;

import com.justcs.config.UploadFileConfig;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.servlet.MultipartConfigElement;
import java.io.File;

@SpringBootApplication
@MapperScan("com.justcs.mapper")
@ComponentScan(basePackages = {"com.justcs.*"})
public class Application  extends SpringBootServletInitializer {

    @Autowired
    private UploadFileConfig uploadFileConfig;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    /**
     * 配置上传的临时位置
     * @return
     */
    @Bean
    MultipartConfigElement multipartConfigElement(){
        String conftemp = uploadFileConfig.getBasetemp();
        if(StringUtils.isBlank(conftemp)) {
            conftemp = "/usr/local/tomcat/confmtemp"; // 设置默认值
        }
        // 判断文件夹是否存在,如果不存在则创建
        File tempFile = new File(conftemp);
        if(!tempFile.exists() && !tempFile.isDirectory()) {
            tempFile.mkdirs();
        }
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation(conftemp);
        return factory.createMultipartConfig();
    }
}
