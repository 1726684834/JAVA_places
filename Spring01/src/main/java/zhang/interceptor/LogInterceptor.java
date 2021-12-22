package zhang.interceptor;

import java.lang.reflect.Method;

/**
 * @author ZhangJunqi
 * @Date 2021/12/21 -22:15
 */
public interface LogInterceptor {
    int before(Method method, Object[] args);
    int after(Method method,Object[] args);
}
