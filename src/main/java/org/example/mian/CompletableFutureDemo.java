package org.example.mian;

import java.security.Security;
import java.util.UUID;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Future>>>>>>>>>>>>>CompletableFuture
 */
public class CompletableFutureDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        /*CompletableFuture<String> future =
                CompletableFuture.supplyAsync(CompletableFutureDemo::doSomething);

        future.thenAccept(new Consumer<String>() {
            @Override
            public void accept(String s) {
                String replace = s.replace("-", "");
                System.out.println(replace);
            }
        });
        future.exceptionally(throwable -> {
            String message = throwable.getMessage();
            System.out.println(message);
            return message;
        });
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executor.close();*/
        /*
         任务串行执行
         */
        /*CompletableFuture<String> future1 = CompletableFuture.supplyAsync(CompletableFutureDemo::UUid);
        future1.thenAcceptAsync(System.out::println);
        */

        /**
         * 任务并行 执行
         */
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(CompletableFutureDemo::Time);
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(CompletableFutureDemo::UUid);
        CompletableFuture<Object> future3 = CompletableFuture.anyOf(future1,future2);
        future3.thenAccept(s-> System.out.println("all:"+s));
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    }


   static String doSomething() {
        if(Math.random()>0.5){
            throw new RuntimeException("参数异常");
        }
        return UUID.randomUUID().toString();
    }
    static String UUid(){
        if(true)
            throw new RuntimeException("参数异常");
        return UUID.randomUUID().toString();
    }
    static String Time(){
       return Long.toString(System.currentTimeMillis());
    }







}

