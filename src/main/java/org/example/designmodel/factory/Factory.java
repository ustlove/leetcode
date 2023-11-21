package org.example.designmodel.factory;

import org.example.designmodel.singleton.Flazysingleton;

/**
 * @ClassName Factory
 * @Description TODO
 * @Author ASUS
 * @Date 2024/3/26 16:14
 * @Version 1.0
 */
public class Factory<T> implements CarFactory{



    @Override
    public Car createCar() {
        return new CarA();
    }
}
