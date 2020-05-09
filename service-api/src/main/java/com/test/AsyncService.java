package com.test;

import java.util.concurrent.CompletableFuture;

public interface AsyncService {
    /**
     * dubbo版本低于2.7不支持 {@link CompletableFuture}
     */
    CompletableFuture<String> sayHello(String name);
}
