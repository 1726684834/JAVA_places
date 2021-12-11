package cn.com.zhang.Class01Singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author ZhangJunqi
 * @Date 2021/12/1 -22:13
 */
public class Demo01Singleton {
    //单例安全的终点是枚举
    /*
    在某种场合下，我们希望一个类只有一个实例就好，实例多了，浪费内存，增加 JVM 垃圾回收的负担。
    构造方法私有，防止在其他地方创建对象，在当前类中提供一个统一的获取对象的方法，保证该方法 只能创建一个对象。
    单例模式常用在多线程环境下，所有多线程环境下的实现方式需要重点掌握

    优缺点分析：提供了对唯一实例的受控访问。因为单例类封装了它的唯一实例，
        所以它可以严格控制客户怎样以及何时访问它，并为设计及开发团队提供了共享的概念。

    由于在系统内存中只存在一个对象，因此可以节约系统资源，对于一些需要频繁创建和销毁的对象，单例模式无疑可以提高系统的性能。

    许可变数目的实例。我们可以基于单例模式进行扩展，使用与单例控制相似的方法来获得指定个数的对象实例。

    由于单例模式中没有抽象层，因此单例类的扩展有很大的困难。

    单例类的职责过重，在一定程度上违背了“单一职责原则”。

    因为单例类既充当了工厂角色，提供了工厂方法，同时又充当了产品角色，包含一些业务方法，将产品的创建和产品的本身的功能融合到 一起。

    滥用单例将带来一些负面问题，如为了节省资源将数据库连接池对象设计为单例类，可能会导致 共享连接池对象的程序过多而出现连接池溢出；

    现在很多面向对象语言(如 Java、C#)的运行环境都提 供了自动垃圾回收的技术，因此，如果实例化的对象长时间不被利用，
        系统会认为它是垃圾，会自动 销毁并回收资源，下次利用时又将重新实例化，这将导致对象状态的丢失
     */
    private static boolean flag=false;
    private static volatile Demo01Singleton instance;

    private Demo01Singleton() {
        synchronized (Demo01Singleton.class){
            if(!flag){
                flag=true;
            }else {
                throw new RuntimeException ("禁止反射");
            }
        }
    }

    public static Demo01Singleton getInstance(){
        if(instance==null){
            synchronized (Demo01Singleton.class){
                if (instance==null){
                    instance=new Demo01Singleton ();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) throws Exception {
        Field flag=Demo01Singleton.class.getDeclaredField ("flag");
        flag.setAccessible (true);
        Constructor<Demo01Singleton> constructor= Demo01Singleton.class.getDeclaredConstructor (null);
        constructor.setAccessible (true);
        Demo01Singleton instance02=constructor.newInstance ();

        flag.set (instance02,false);
        Demo01Singleton instance03=constructor.newInstance ();
        System.out.println(instance02);//cn.com.zhang.Class01Singleton.Demo01Singleton@74a14482
        System.out.println(instance03);//cn.com.zhang.Class01Singleton.Demo01Singleton@1540e19d
    }

}
