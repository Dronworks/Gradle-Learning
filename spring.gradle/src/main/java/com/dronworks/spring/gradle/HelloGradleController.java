package com.dronworks.spring.gradle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloGradleController {

    @GetMapping("/hello")
    public String hello() {
        return "Spring boot with gradle is super easy";
    }

}
