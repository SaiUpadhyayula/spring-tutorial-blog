package com.programming.techie.springtutorialblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.programming.techie.springtutorialblog")
@ImportAutoConfiguration({FeignAutoConfiguration.class})
@EnableConfigurationProperties
public class SpringTutorialBlogApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringTutorialBlogApplication.class, args);
    }


}
