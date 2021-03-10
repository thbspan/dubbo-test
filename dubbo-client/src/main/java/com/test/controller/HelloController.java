package com.test.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.IHello;
import com.test.entity.TestBean;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @DubboReference(version = "1.0", cluster = "failover", check = false)
    private IHello hello;

    @GetMapping("/{id}")
    public TestBean test(@PathVariable("id") int id) {
        return hello.get(id);
    }
}
