package cn.com.zhang.Class03Factory;

import cn.com.zhang.Class02SimpleFactory.Car;

/**
 * @author ZhangJunqi
 * @Date 2021/12/2 -22:49
 */
public class CarFactoryTest {
    /*
    工厂方法模式将创建具体产品对象的任务分配给了对应的子类工厂，后期扩展新的产品时只需要扩展新的产品类和对应的工厂即可，
    不修改现有的实现。

    这一点符合“开闭原则”。 工厂方法模式虽然满足“开闭原则”，但是其缺点也是显而易见的。
    当产品种类非常多时，会出现大量的与之对应的工厂对象，这不是我们所希望的。
     */
    public static void main(String[] args) {
        CarFactory carFactory=new JeepFactory ();
        Car jeep=carFactory.getCar ();
        jeep.getType ();

        carFactory=new SimpleFactory ();
        Car simpleCar=carFactory.getCar ();
        simpleCar.getType ();

    }
}
