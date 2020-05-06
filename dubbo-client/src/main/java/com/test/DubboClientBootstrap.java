package com.test;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DubboClientBootstrap {

    /**
     * 设置版本号和容错机制
     * failover 默认 重试其他服务器；retries 重试次数 默认 2
     * failsafe null 吞掉错误，返回null，不会报异常
     * mock force强制执行
     * return empty
     * http://dubbo.apache.org/zh-cn/docs/user/demos/local-mock.html
     */
    @Reference(version = "0.0.1", cluster = "failover", check = false)
    private IHello hello;

    @Reference(timeout = 5000)
    private AsyncService asyncService;

    public static void main(String[] args) {
        SpringApplication.run(DubboClientBootstrap.class).close();
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            System.out.println(hello.say("jack"));
            System.out.println(hello.get(1));
            asyncService.sayHello("jack").whenComplete((v, t) -> {
                if (t != null) {
                    t.printStackTrace();
                } else {
                    System.out.println("Async Response: " + v);
                }
            });
        };
    }
}
