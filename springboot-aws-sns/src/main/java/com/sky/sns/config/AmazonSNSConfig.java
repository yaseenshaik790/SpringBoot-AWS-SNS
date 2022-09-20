package com.sky.sns.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AmazonSNSConfig {

    @Value("${aws.sns.region}")
    private String region;

    @Primary
    @Bean
    public AmazonSNSClient amazonSNSClient(){
        return (AmazonSNSClient) AmazonSNSClientBuilder.standard()
                .withRegion(region).withCredentials(new AWSStaticCredentialsProvider(
                        new BasicAWSCredentials("your_access_key",
                                "your_access_secrets"))).build();
    }
}
