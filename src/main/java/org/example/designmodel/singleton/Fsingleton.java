package org.example.designmodel.singleton;

/**
 * @ClassName Fsingleton
 * @Description TODO
 * @Author ASUS
 * @Date 2024/3/26 15:55
 * @Version 1.0
 */
//饥饿加载
public class Fsingleton {
    //类初始化，会立即加载
    private static final Fsingleton instance = new Fsingleton();
    private Fsingleton(){

    }
    public static Fsingleton getInstance(){
        return instance;
    }


}
