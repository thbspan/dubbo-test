package com.test.dubbo;

public class Apple implements Fruit {
    @Override
    public String getName(FruitInfo fruitInfo) {
        return "apple";
    }

    @Override
    public String test() {
        return "apple test";
    }
}
