package cn.com.zhang.Class02SimpleFactory;

/**
 * @author ZhangJunqi
 * @Date 2021/12/2 -22:36
 */
public class CarFactory {
    /*
        传统的创建对象方式：在设计系统的时候，需要对象就用 new 关键创建。
        弊端分析：这样做的话，对象的创建分散的很多 java 类中，给后期的系统维护带来很大的不便。
        解决思路：将对象 的创建尽量集中在某个地方，这样有利于后期的扩展和维护。
        实例：需要创建一批汽车对象， 例如：越野车、吉普车、轿车和商务车等。

        将对象的创建集中的工厂类中创建，实现了对象和使用者之间的解耦，同时也有利于后期的维护。
        加入后期需要扩展新的车型，需要修改工厂类，这一点违背了“开闭原则”，即对扩展开放，对修改关闭
     */
    public static Car getCar(int type){
        Car car=null;
        if(type==1){
            car =new JeepCar ();
        }else if(type==2){
            car=new SimpleCar ();
        }
        return car;
    }

    public static void main(String[] args) {
        Car jeepCar=CarFactory.getCar (1);
        jeepCar.getType ();
        Car simpleCar=CarFactory.getCar (2);
        simpleCar.getType ();
    }
}
