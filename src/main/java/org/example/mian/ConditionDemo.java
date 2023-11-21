package org.example.mian;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 唤醒
 */
public class ConditionDemo {
    public static void main(String[] args) {
        TaskQueue taskQueue = new TaskQueue();
       Thread t1 =  new Thread(() -> {
           taskQueue.add(UUID.randomUUID().toString());
           while (true){
               Scanner scan = new Scanner(System.in);
               taskQueue.add(scan.nextLine());
           }

        });

        Thread t2 = new Thread(() -> {
            while (true) taskQueue.remove();
        });
      t1.start();
      t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }



 static class TaskQueue{
    private static Queue<String> queue = new LinkedList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public  void add(String task) {
        lock.lock();
        try {
            while (queue.isEmpty())
            queue.add(task);
            System.out.println("add :"+task);
            condition.signalAll();
        } finally {
            // 无论标志是否被修改，都必须释放锁
            lock.unlock();
        }

    }
    public void remove(){
        lock.lock();
        try {
            if (queue.isEmpty())
                condition.await();
            String task = queue.poll();
            System.out.println("poll :"+task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();    }




}
}


