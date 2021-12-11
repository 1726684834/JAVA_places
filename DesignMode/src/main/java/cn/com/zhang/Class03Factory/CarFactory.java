package cn.com.zhang.Class03Factory;

import cn.com.zhang.Class02SimpleFactory.Car;

/**
 * @author ZhangJunqi
 * @Date 2021/12/2 -22:46
 */
public interface CarFactory {
    /*
    工厂方法模式 、需求 在简单工厂的基础之上，如果要实现扩展新的车型，能不能不修改已有的实现就能满足需要呢？
    即需 要符合“开闭原则” 解决思路：创建工厂的抽象类，创建具体产品的任务由抽象工厂类的具体子类来承担。
     */
    Car getCar();
}
