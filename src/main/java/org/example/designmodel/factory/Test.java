package org.example.designmodel.factory;

/**
 * @ClassName Test
 * @Description TODO
 * @Author ASUS
 * @Date 2024/3/26 16:15
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        CarFactory carFactory = new Factory<>();
        carFactory.createCar().run();



    }
}
