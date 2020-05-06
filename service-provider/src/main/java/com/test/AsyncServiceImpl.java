package com.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class AsyncServiceImpl implements AsyncService {
    @Override
    public CompletableFuture<String> sayHello(String name) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                // ignore exception
            }
            return "Hello " + name;
        });
    }
}
