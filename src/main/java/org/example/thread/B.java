package org.example.thread;

/**
 * @ClassName B
 * @Description TODO
 * @Author ASUS
 * @Date 2024/3/27 9:23
 * @Version 1.0
 */
public class B implements DB{
    @Override
    public void ada() {
        System.out.println(a());
    }
}
