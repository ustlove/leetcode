package org.example.mian;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *悲观锁
 *
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {

        Counter counter = new Counter();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
              counter.add();
            }).start();
        }



        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                counter.get();
                System.out.println(Thread.currentThread().getName() + "" +
                        "get i :"+counter.get()+System.currentTimeMillis());
            }).start();
        }
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }






    static  class Counter{

        private static  int i = 0;
        /**
         * 读锁多个线程可读入
         */
        private final Lock read_lock = new ReentrantReadWriteLock().readLock();
        /**
         * 写锁多个线程可写入
         */
        private final Lock write_lock = new ReentrantReadWriteLock().writeLock();


        public void add(){
            try {
                write_lock.lock();
                System.out.println(System.currentTimeMillis());
                i++;
                /*TimeUnit.SECONDS.sleep(1);*/

            } finally {
                write_lock.unlock();
            }
        }
        public int get(){
            try {
                read_lock.lock();
                TimeUnit.MILLISECONDS.sleep(1000);
                return i;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                read_lock.unlock();
            }
        }




    }




}
