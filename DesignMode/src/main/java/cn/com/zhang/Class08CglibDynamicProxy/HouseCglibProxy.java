package cn.com.zhang.Class08CglibDynamicProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author ZhangJunqi
 * @Date 2021/12/4 -23:12
 */
public class HouseCglibProxy implements MethodInterceptor {

    public Object getProxy(Class clas){
        Enhancer enhancer = new Enhancer ();
        enhancer.setSuperclass (clas);
        enhancer.setCallback (this);
        return enhancer.create ();
    }
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object res = methodProxy.invokeSuper (o, objects);
        after();
        return res;
    }
    private void before() {
        System.out.println("调用真实对象方法前。。。");
    }

    private void after() {
        System.out.println("调用真实对象方法后。。。");
    }
}
