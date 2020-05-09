package com.test.dubbo;

import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

@SPI("apple")
public interface Fruit {
    @Adaptive
    String getName(FruitInfo fruitInfo);

    String test();
}
