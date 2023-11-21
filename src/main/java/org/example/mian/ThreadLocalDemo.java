package org.example.mian;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo {
    public static void main(String[] args) {

        Demo demo = new Demo();
        demo.add(UUID.randomUUID().toString());
        System.out.println(demo.get());
        new Thread(() -> {
            try {
                System.out.println(demo.get());
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();



    }

static class Demo{
        private static  ThreadLocal<String> local = new ThreadLocal<>();

        public void add(String value) {
            local.set(value);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(local.get());
        }
        public void remove() {
            local.remove();
        }
        public String get() {
            return local.get();
        }
        public ThreadLocal<String> getLocal() {
            return local;
        }


}

}

