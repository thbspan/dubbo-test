package com.test.dubbo;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.rpc.Filter;
import org.junit.Test;

public class ExtensionTest {

    @Test
    public void testDefaultExtension() {
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

    }

    @Test
    public void testAdaptiveExtension() {
        System.out.println(ExtensionLoader.getExtensionLoader(Fruit.class).getAdaptiveExtension());

//        public java.lang.String test()  {
//            throw new UnsupportedOperationException("The method public abstract java.lang.String com.test.dubbo.Fruit.test() of interface com.test.dubbo.Fruit is not adaptive method!");
//        }
    }

    @Test
    public void testActivateExtension() {
        URL url = new URL("", "localhost", 2181);
//        url = url.addParameter("cache", "cache");
//        url = url.addParameter("cache", "jcache");
        url = url.addParameter("cache", "echo");
        ExtensionLoader.getExtensionLoader(Filter.class).getActivateExtension(url, "cache").forEach(System.out::println);
    }
}
