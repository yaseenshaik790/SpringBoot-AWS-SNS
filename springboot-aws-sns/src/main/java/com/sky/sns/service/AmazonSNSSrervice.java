package com.sky.sns.service;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AmazonSNSSrervice {

    @Value("${aws.sns.topicArn}")
    private String topicArn;

    @Autowired
    private AmazonSNSClient snsClient;

    public Object subscribe(String email) {
        SubscribeRequest subscribeRequest = new SubscribeRequest(topicArn,"email",email);
        snsClient.subscribe(subscribeRequest);
        return "Subscription was completed with Email ID: "+email;
    }

    public Object publish(String message) {

        PublishRequest request = new PublishRequest(topicArn,message,"Welcome AWS SNS");
        snsClient.publish(request);
        return "Message Sent Successfully";
    }
}
