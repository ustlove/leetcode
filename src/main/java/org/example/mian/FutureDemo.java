package org.example.mian;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Future<String> submit = executor.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "");
            return "执行成功";
        });
        String s = submit.get();
        System.out.println(s);

    }
}
