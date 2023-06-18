package org.whitestar.TimberDemo.configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import io.micrometer.common.util.StringUtils;
import lombok.Setter;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories
        (basePackages = "org.whitestar.TimberDemo.repository")
@Setter
public class DynamoDBConfiguration {
    private DynamoDBConfigurationProperties dynamoDBConfigurationProperties;
    @Autowired
    public DynamoDBConfiguration(DynamoDBConfigurationProperties dynamoDBProperties) {
        this.dynamoDBConfigurationProperties = dynamoDBProperties;
    }

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        AmazonDynamoDB amazonDynamoDB
                = new AmazonDynamoDBClient(amazonAWSCredentials());
        String amazonDynamoDBEndpoint = dynamoDBConfigurationProperties.getEndpoint();
        if (!StringUtils.isEmpty(amazonDynamoDBEndpoint)) {
            amazonDynamoDB.setEndpoint(amazonDynamoDBEndpoint);
        }

        return amazonDynamoDB;
    }

    @Bean
    public AWSCredentials amazonAWSCredentials() {
        String amazonAWSAccessKey = dynamoDBConfigurationProperties.getAccessKey();
        String amazonAWSSecretKey = dynamoDBConfigurationProperties.getSecretKey();
        return new BasicAWSCredentials(
                amazonAWSAccessKey, amazonAWSSecretKey);
    }
}