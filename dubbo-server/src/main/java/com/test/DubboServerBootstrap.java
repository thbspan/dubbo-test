package com.test;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

@SpringBootApplication
public class DubboServerBootstrap {
    private static final String RES_KEY = "com.test.IHello:say(java.lang.String)";

    /**
     * add the flow sentinel VM arguments
     *
     * -Djava.net.preferIPv4Stack=true
     * -Dcsp.sentinel.api.port=8720
     * -Dcsp.sentinel.dashboard.server=localhost:9090
     * -Dproject.name=dubbo-server
     */
    public static void main(String[] args) {
        initFlowRule();
        SpringApplication.run(DubboServerBootstrap.class, args);
    }

    private static void initFlowRule() {
        FlowRule flowRule = new FlowRule();
        flowRule.setResource(RES_KEY);
        flowRule.setCount(5);
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // 不区分调用来源
        flowRule.setLimitApp("default");
        FlowRuleManager.loadRules(Collections.singletonList(flowRule));
    }
}
