package org.example.designmodel.singleton;

/**
 * @ClassName Singleton
 * @Description TODO
 * @Author ASUS
 * @Date 2024/3/26 16:03
 * @Version 1.0
 */
public class Singleton {
    static class SingletonHolder{
        private static  final  Singleton instance = new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonHolder.instance;
    }

    public static void main(String[] args) {
        Runnable task = ()->{
            System.out.println(Singleton.getInstance());
            System.out.println(System.nanoTime());
        };

        for (int i = 0; i < 2; i++) {
            new Thread(task).start();
        }
    }




}
