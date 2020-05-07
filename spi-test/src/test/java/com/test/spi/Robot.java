package com.test.spi;

import org.apache.dubbo.common.extension.SPI;

@SPI("Bumblebee")
public interface Robot {

    void sayHello();
}
