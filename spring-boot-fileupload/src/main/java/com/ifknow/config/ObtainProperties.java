package com.ifknow.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: ifknow <br>
 * @Date: 2020/8/25  10:18 <br>
 * @Description: 读取配置文件中定义的文件上传路径
 */
@Configuration
@ConfigurationProperties(prefix = "my", ignoreUnknownFields = false)
public class ObtainProperties {
    /**
     * 文件上传配置
     */
    private final UploadFile uploadFile = new UploadFile();

    public UploadFile getUploadFile() {
        return uploadFile;
    }

    @Data
    public static class UploadFile {
        private String uploadPath;
        private String readPath;
    }
}
