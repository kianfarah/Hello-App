package com.farah.helloapp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/greeting")
public class HelloController {
    private final Logger log = LoggerFactory.getLogger(HelloController.class);
    @GetMapping
    public String hello() {
        log.info("Hello World called");
        return "Hello World!";
    }
}
