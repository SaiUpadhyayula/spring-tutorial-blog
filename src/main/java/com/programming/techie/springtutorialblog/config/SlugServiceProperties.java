package com.programming.techie.springtutorialblog.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "slug.service")
@Component
@Getter
@Setter
public class SlugServiceProperties {
    private String url;
}
