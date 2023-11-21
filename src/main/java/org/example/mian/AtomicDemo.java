package org.example.mian;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子类
 */
public class AtomicDemo {
    public static void main(String[] args) throws InterruptedException {
        Demo demo = new Demo();
        for (int i = 0; i < 1000; i++){
            new Thread(demo::add).start();
        }
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println(demo.get());


    }

  static class Demo{
       private static AtomicInteger atomicInteger = new AtomicInteger(0);
       public void add(){
          atomicInteger.set(atomicInteger.incrementAndGet());
       }
       public void desc(){
           atomicInteger.set(atomicInteger.decrementAndGet());
       }
       public int  get(){
          return atomicInteger.get();
       }
  }


}
