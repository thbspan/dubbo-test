package com.test.dubbo;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

public class ExtensionTest {

    @Test
    public void test() {
        // getExtensionLoader 根据class 获得 ExtensionLoader
        // ExtensionLoader 构造函数是私有的，只能通过工厂方法获取
//        System.out.println(ExtensionLoader
//                        .getExtensionLoader(Protocol.class)
//                        .getAdaptiveExtension()
////                .getDefaultExtension()
////                .getDefaultPort()
//        );

        // Protocol.class -> Protocol$Adaptive 动态生成的类文件
        System.out.println(ExtensionLoader
                .getExtensionLoader(Fruit.class).getDefaultExtension()
        );
        System.out.println(ExtensionLoader.getExtensionLoader(Fruit.class).getAdaptiveExtension());
    }
}
