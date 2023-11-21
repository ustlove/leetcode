package org.example.aqs;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Aqs
 * @Description TODO
 * @Author ASUS
 * @Date 2024/3/26 16:41
 * @Version 1.0
 */
public class Aqs {
    private static Integer count = 10000;
    static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        Runnable task = ()-> {
            for (int i = 0; i < 100; i++) {
               try {
                   if(lock.tryLock(2,TimeUnit.SECONDS)){
                       count = count-1;

                   }
               }catch (InterruptedException e){
                   throw new RuntimeException();
               }
               finally {
                   lock.unlock();
               }
            }
        };
        for (int i = 0; i < 100; i++) {
            new Thread(task,"thread-"+i).start();
        }
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(count);

    }
}
