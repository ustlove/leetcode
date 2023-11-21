package org.example.mian;

import java.util.concurrent.*;

/**
 * 线程池
 */
public class ExecutorServiceDemo {
    public static final ExecutorService executor1 = Executors.newCachedThreadPool();
    public static final ScheduledExecutorService executor2 = Executors.newScheduledThreadPool(3);

    public static void main(String[] args) {
        /*for (int i = 0; i < 10; i++){
            executor1.submit(()-> System.out.println(Thread.currentThread().getName() + System.currentTimeMillis()));
        }*/
        /*
         * 1秒后执行任务
         */
           /* executor2.schedule(() -> {

                System.out.println(Thread.currentThread().getName() + "");
            },1,TimeUnit.SECONDS);*/
        /*
         *每一秒执行一次，任务以指定速率开始
         * 不管任务有没有完成
         */
       /* executor2.scheduleAtFixedRate(()->{

                    System.out.println(Thread.currentThread().getName() + ""+System.currentTimeMillis());}
                    ,0,1,TimeUnit.SECONDS);*/
        executor2.scheduleWithFixedDelay(()->
                {
                    try {
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println("\n");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                System.out.println(Thread.currentThread().getName() + ""+System.currentTimeMillis());},
        0,1,TimeUnit.SECONDS);


    }


}
