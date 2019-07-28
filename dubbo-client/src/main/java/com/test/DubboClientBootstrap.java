package com.test;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration
public class DubboClientBootstrap {

    @Reference(url = "dubbo://192.168.0.108:9527")
    private IHello hello;

    public static void main(String[] args) {
        SpringApplication.run(DubboClientBootstrap.class).close();
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> System.out.println(hello.say("jack"));
    }
}
