package com.test;

public class HelloImpl implements IHello {
    @Override
    public String say(String msg) {
        return "Hi " + msg;
    }
}
