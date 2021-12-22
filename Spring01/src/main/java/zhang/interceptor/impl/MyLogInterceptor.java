package zhang.interceptor.impl;

import org.springframework.stereotype.Component;
import zhang.interceptor.LogInterceptor;

import java.lang.reflect.Method;

/**
 * @author ZhangJunqi
 * @Date 2021/12/21 -22:25
 */
@Component
public class MyLogInterceptor implements LogInterceptor {

    @Override
    public int before(Method method, Object[] args) {
        return 0;
    }

    @Override
    public int after(Method method, Object[] args) {
        return 0;
    }
}
