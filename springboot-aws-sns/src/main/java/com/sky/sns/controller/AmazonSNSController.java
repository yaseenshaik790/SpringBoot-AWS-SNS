package com.sky.sns.controller;

import com.sky.sns.service.AmazonSNSSrervice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AmazonSNSController {

    @Autowired
    private AmazonSNSSrervice amazonSNSSrervice;

    @PostMapping(value = "/subscribe/{email}")
    @ResponseStatus(HttpStatus.CREATED)
    public Object subscribe(@PathVariable String email) {
        return amazonSNSSrervice.subscribe(email);
    }

    @PostMapping(value = "/publish")
    @ResponseStatus(HttpStatus.OK)
    public Object publish(@RequestParam String message) {
        return amazonSNSSrervice.publish(message);
    }
}
