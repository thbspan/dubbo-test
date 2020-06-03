package com.test;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.alibaba.dubbo.config.annotation.Reference;

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
    @Reference(version = "1.0", cluster = "failover", check = false, mock = "com.test.mock.MockIHello")
    private IHello hello;

    /**
     * add the flow sentinel VM arguments
     *
     * -Djava.net.preferIPv4Stack=true
     * -Dcsp.sentinel.api.port=8721
     * -Dcsp.sentinel.dashboard.server=localhost:9090
     * -Dproject.name=dubbo-client
     */
    public static void main(String[] args) {
        SpringApplication.run(DubboClientBootstrap.class).close();
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            // test qps
            for (int i = 0; i < 15; i++) {
                try {
                    System.out.println(hello.say("jack"));
                    System.out.println(hello.get(1));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        };
    }
}
