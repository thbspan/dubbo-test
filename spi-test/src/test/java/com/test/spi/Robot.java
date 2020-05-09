package com.test.spi;

import com.alibaba.dubbo.common.extension.SPI;

@SPI("Bumblebee")
public interface Robot {

    void sayHello();
}
