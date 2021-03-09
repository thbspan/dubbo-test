package com.test;

import com.test.entity.TestBean;

public class HelloImpl implements IHello {
    @Override
    public String say(String msg) {
        return "Hi " + msg;
    }

    @Override
    public TestBean get(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("id must >= 0");
        } else if (id >= 10000) {
            throw new RuntimeException("id is too big!");
        }
        TestBean testBean = new TestBean();
        testBean.setName("test");
        return testBean;
    }
}
