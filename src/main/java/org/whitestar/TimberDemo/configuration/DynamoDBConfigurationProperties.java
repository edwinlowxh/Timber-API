package org.whitestar.TimberDemo.configuration;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "dynamodb")
public class DynamoDBConfigurationProperties {
    private String accessKey;
    private String endpoint;
    private String secretKey;
}
