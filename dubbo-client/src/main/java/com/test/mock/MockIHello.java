package com.test.mock;

import com.test.IHello;
import com.test.entity.TestBean;

public class MockIHello implements IHello {
    @Override
    public String say(String msg) {
        return "mock say " + msg;
    }

    @Override
    public TestBean get(int id) {
        TestBean testBean = new TestBean();
        testBean.setName("mock");
        return testBean;
    }
}
