package com.test.dubbo;

public class Apple implements Fruit {
    @Override
    public String getName(FruitInfo fruitInfo) {
        return "apple";
    }
}
