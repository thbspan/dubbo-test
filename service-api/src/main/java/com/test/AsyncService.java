package com.test;

import java.util.concurrent.CompletableFuture;

public interface AsyncService {
    CompletableFuture<String> sayHello(String name);
}
