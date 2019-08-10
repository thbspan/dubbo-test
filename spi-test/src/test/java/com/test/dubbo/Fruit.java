package com.test.dubbo;

import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

@SPI("apple")
public interface Fruit {
    @Adaptive
    String getName(FruitInfo fruitInfo);

    String test();
}
