package com.test.spi;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

public class DubboSPITest {
    @Test
    public void testSayHello() throws Exception {
        ExtensionLoader<Robot> extensionLoader = ExtensionLoader.getExtensionLoader(Robot.class);
        Robot optimusPrime = extensionLoader.getExtension("OptimusPrime");
        optimusPrime.sayHello();
        Robot bumblebee = extensionLoader.getExtension("Bumblebee");
        bumblebee.sayHello();
        extensionLoader.getSupportedExtensions().forEach(System.out::println);
//        System.out.println(extensionLoader.getAdaptiveExtension());
    }
}
