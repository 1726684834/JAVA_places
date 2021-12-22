package zhang.proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zhang.interceptor.LogInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ZhangJunqi
 * @Date 2021/12/21 -22:16
 */
@Component
public class ServiceProxy implements InvocationHandler {
    //持有被代理的对象
    Object target;
    //注入日志拦截器对象
    @Autowired
    LogInterceptor logInterceptor;
    //创建一个代理类生成方法
    public Object build(Object target){
        this.target=target;
        return Proxy.newProxyInstance (target.getClass ().getClassLoader (),target.getClass ().getInterfaces (),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logInterceptor.before (method,args);
        Object res=method.invoke (target,args);
        logInterceptor.after (method,args);
        return res;
    }
}
