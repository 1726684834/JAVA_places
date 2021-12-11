package cn.com.zhang.Class07JDKDynamicProxy;

import cn.com.zhang.Class06StaticProxy.Buyer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ZhangJunqi
 * @Date 2021/12/4 -17:07
 */
//代理
public class CompanyProxy implements InvocationHandler {
    private Object buyer;
    public Object getInstance(Object buyer){
        this.buyer=buyer;
        Class<?> clazz=buyer.getClass ();
        return Proxy.newProxyInstance (clazz.getClassLoader (),clazz.getInterfaces (),this);
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object object=method.invoke (this.buyer,args);
        after();
        return object;
    }

    private void before() {
        System.out.println("代理前工作");
    }

    private void after() {
        System.out.println("代理后工作");
    }

}
