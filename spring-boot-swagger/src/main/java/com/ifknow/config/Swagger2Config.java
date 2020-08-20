package com.ifknow.config;

import com.ifknow.annotation.Api_Base;
import com.ifknow.annotation.Api_Business;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: ifknow <br>
 * @Date: 2020/8/20  11:19 <br>
 * @Description: Swagger2 配置类
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Value("${swagger2.enable}")
    private boolean enable;

    /**
     * 配置swagger2核心配置docket </br>
     * swagger访问路径：http://localhost:8081/swagger-ui.html </br>
     * swagger业务接口api
     *
     * @return
     */
    @Bean
    public Docket restApiBusiness() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("业务分组接口")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api_Business.class))
                .paths(PathSelectors.any())
                .build()
                .enable(enable);
    }

    @Bean
    public Docket restApiBase() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("基础接口")
                .apiInfo(apiInfoBase())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api_Base.class))
                .paths(PathSelectors.any())
                .build()
                .enable(enable);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("业务分组接口")
                .contact(new Contact("ifknow", "http://www.gongshiyong.online", "shiyongjava@163.com"))
                .description("ifknow测试Swagger")
                .version("1.0.0")
                .termsOfServiceUrl("http://www,gongshiyong.online")
                .build();
    }

    private ApiInfo apiInfoBase() {
        return new ApiInfoBuilder()
                .title("基础接口")
                .contact(new Contact("ifknow", "http://www.gongshiyong.online", "shiyongjava@163.com"))
                .description("ifknow测试Swagger")
                .version("1.0.0")
                .termsOfServiceUrl("http://www,gongshiyong.online")
                .build();
    }
}
