package org.example.designmodel.singleton;

/**
 * @ClassName Flazysingleton
 * @Description TODO
 * @Author ASUS
 * @Date 2024/3/26 15:58
 * @Version 1.0
 */
//懒加载
public class Flazysingleton {
    private static volatile Flazysingleton instance ;
    public static Flazysingleton getInstance(){
        if(instance != null) return instance;
        synchronized (Flazysingleton.class){

            instance = new Flazysingleton();
            return instance;
        }
    }

    public static void main(String[] args) {
        Runnable task = ()->{
            Flazysingleton instance1 = Flazysingleton.getInstance();
            System.out.println(instance1);
        };
        for (int i = 0; i < 3; i++) {
            new Thread(task).start();

        }

    }
}
