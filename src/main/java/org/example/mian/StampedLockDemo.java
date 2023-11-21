package org.example.mian;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * 乐观锁
 */
public class StampedLockDemo {
    public static void main(String[] args) throws InterruptedException {
        Point p = new Point();
        for (int i = 0; i < 10; i++) {
            new Thread(p::distance_from_origin).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(
                    ()->
                    {
                        try {
                            TimeUnit.MILLISECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        p.move(3.0,4.0);

                    }

            ).start();

        }
        /*TimeUnit.MILLISECONDS.sleep(1000);*/

        TimeUnit.MILLISECONDS.sleep(5000);

    }







static class Point {
    private static double x,y;
    private final StampedLock stampedLock = new StampedLock();

   public void move(double deltaX, double deltaY) {

        long l = stampedLock.writeLock();//获取写锁
        System.out.println(" move:  version: [ "+l +" ]");
        try {
            x=x+deltaX;
            y = y+deltaY;
        }finally {
            stampedLock.unlockWrite(l);//释放写锁
        }

    }
 public void distance_from_origin(){
        long l = stampedLock.tryOptimisticRead();//获取一个乐观读锁
        System.out.println("distance_from_origin: "+" version: [ "+l +" ]");
        double current_x = x;
        double current_y = y;

            if(!stampedLock.validate(l)){//判断乐观锁后是否有其他写锁发生
                l = stampedLock.readLock();
                try {
                    current_x = x;
                    current_y = y;
                }finally {
                    stampedLock.unlockRead(l);//释放读锁
                }
            }
     double hypot = Math.hypot(current_x, current_y);
     System.out.println(hypot);


 }



}
}
