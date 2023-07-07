package com.nickperov.stud.java_samples.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        simpleFuture();
    }


    private static void simpleFuture() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future
                = CompletableFuture.supplyAsync(() -> "Hello [" + Thread.currentThread().getName() + "]");
        System.out.println(future.get());
    }

}
