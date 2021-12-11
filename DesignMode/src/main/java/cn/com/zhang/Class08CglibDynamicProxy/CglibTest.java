package cn.com.zhang.Class08CglibDynamicProxy;

import cn.com.zhang.Class06StaticProxy.Buyer;
import cn.com.zhang.Class06StaticProxy.HouseBuyer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @author ZhangJunqi
 * @Date 2021/12/4 -23:27
 */
public class CglibTest {
    public static void main(String[] args) throws ClassNotFoundException {
        HouseCglibProxy methodInterceptor=new HouseCglibProxy ();
        Buyer houseBuyer= (Buyer) methodInterceptor.getProxy (Class.forName ("cn.com.zhang.Class06StaticProxy.HouseBuyer"));
        houseBuyer.buy ();
    }
}
