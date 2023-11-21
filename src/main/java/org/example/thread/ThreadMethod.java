package org.example.thread;

import java.util.concurrent.*;

/**
 * @ClassName ThreadMethod
 * @Description TODO
 * @Author ASUS
 * @Date 2024/3/27 8:25
 * @Version 1.0
 */
public class ThreadMethod {
   static final Object lock = new Object();
   static final CountDownLatch count = new CountDownLatch(3);
    static final Runnable task = ()->{

        System.out.println(System.currentTimeMillis());

        count.countDown();

    };

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Boolean> washJob =CompletableFuture.supplyAsync(
                ()->{
                    System.out.println("wash over");
                    return true;
                }
        );
        CompletableFuture<Boolean> hotJob = CompletableFuture.supplyAsync(()->{
            System.out.println("hot over");
            return true;
        });
      CompletableFuture<Boolean> drinkJob = washJob.thenCombine(hotJob,(hot,wash)->{
          if (hot && wash){
              System.out.println("drink ok");
              return true;
          }
          return false;
      });












    }


}
