package cn.com.zhang.Class03Factory;

import cn.com.zhang.Class02SimpleFactory.Car;
import cn.com.zhang.Class02SimpleFactory.JeepCar;

/**
 * @author ZhangJunqi
 * @Date 2021/12/2 -22:48
 */
public class JeepFactory implements CarFactory{
    public Car getCar() {
        return new JeepCar ();
    }
}
