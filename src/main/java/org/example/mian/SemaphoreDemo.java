package org.example.mian;

import java.util.UUID;
import java.util.concurrent.Semaphore;

/**
 * 信号量
 */
public class SemaphoreDemo {
    

    public static void main(String[] args) {
        AccessLimit accessLimit = new AccessLimit();
        for (int i = 0; i <10 ;i++){
            new Thread(accessLimit::startAccessLimit).start();
        }
    }
  static class AccessLimit{
      public final Semaphore semaphore = new Semaphore(3);


      public void startAccessLimit() {
          try {
              semaphore.acquire();
              System.out.println(System.currentTimeMillis());

          } catch (InterruptedException e) {
              throw new RuntimeException(e);
          }finally {
              semaphore.release();
          }


      }

  }
    
    
    
    
}
