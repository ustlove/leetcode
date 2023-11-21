package org.example.mian;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入 锁
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        Counter counter = new Counter();
            new Thread(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }for (int i = 0; i < 10000; i++) counter.add();}).start();
            new Thread(() -> {try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }for(int i = 0; i < 10000; i++) counter.dec();}).start();
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Counter.i);

        
    }
    
    static class Counter {
        public static int i = 0;
        private final Lock lock = new ReentrantLock();
        
        public void add(){
            lock.lock();
             i = i+1;
             lock.unlock();
        }
        public void dec(){
            lock.lock();
            i=i-1;
            lock.unlock();
        }
    }

    
}
