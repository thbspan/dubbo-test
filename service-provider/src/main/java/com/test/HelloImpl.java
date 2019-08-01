package com.test;

import com.test.entity.TestBean;

public class HelloImpl implements IHello {
    @Override
    public String say(String msg) {
        return "Hi " + msg;
    }

    @Override
    public TestBean get(int id) {
        TestBean testBean = new TestBean();
        testBean.setName("test");
        return testBean;
    }
}
