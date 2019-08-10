package com.test.dubbo;

public class Banana implements Fruit{
    @Override
    public String getName(FruitInfo fruitInfo) {
        return "banana";
    }

    @Override
    public String test() {
        return "banana test";
    }
}
