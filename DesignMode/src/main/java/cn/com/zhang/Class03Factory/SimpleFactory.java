package cn.com.zhang.Class03Factory;

import cn.com.zhang.Class02SimpleFactory.Car;
import cn.com.zhang.Class02SimpleFactory.SimpleCar;

/**
 * @author ZhangJunqi
 * @Date 2021/12/2 -22:48
 */
public class SimpleFactory implements CarFactory {
    public Car getCar() {
        return new SimpleCar ();
    }
}
