package com.test.mock;

import com.test.IHello;

public class MockIHello implements IHello {
    @Override
    public String say(String msg) {
        return "mock say " + msg;
    }
}
