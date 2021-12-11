package cn.com.zhang.Class06StaticProxy;

import java.lang.reflect.Proxy;

/**
 * @author ZhangJunqi
 * @Date 2021/12/4 -16:47
 */
public class Test {
    public static void main(String[] args) {
        Buyer houseBuyer=new HouseBuyer ();
        Buyer buyProxy=new BuyProxy (houseBuyer);
        buyProxy.buy ();
        /*
        代理模式的工作原理很像我们买房子，找中介帮你找房子办理手续买房子，你只需要交钱就行
        代理模式给某一个对象提供一个代理对象，并由代理 对象控制对原对象的引用。
         */
    }
}
