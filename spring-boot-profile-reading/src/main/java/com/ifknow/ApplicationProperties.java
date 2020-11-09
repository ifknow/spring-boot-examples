package com.ifknow;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author: GongShiYong <br>
 * @date: 2020/10/17  13:46 <br>
 * @description: NO Description
 */
@ConfigurationProperties(prefix = "my", ignoreUnknownFields = false)
@Configuration
public class ApplicationProperties {

    /**
     * 向外的get方法
     * @return
     */
    public Properties getProperties() {
        return properties;
    }

    private final Properties properties = new Properties();

    public static class Properties {
        private String username;
        private String email;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
