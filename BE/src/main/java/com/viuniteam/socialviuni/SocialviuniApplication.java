package com.viuniteam.socialviuni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.viuniteam.socialviuni")
public class SocialviuniApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialviuniApplication.class, args);
        
    }

}
