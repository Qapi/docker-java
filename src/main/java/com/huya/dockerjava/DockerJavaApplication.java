package com.huya.dockerjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DockerJavaApplication {

    public static void main(String[] args) {
        System.setProperty("hadoop.home.dir", "D:\\huya\\winutils");
        SpringApplication.run(DockerJavaApplication.class, args);
    }
}
