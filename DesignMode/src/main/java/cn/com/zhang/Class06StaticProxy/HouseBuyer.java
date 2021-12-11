package cn.com.zhang.Class06StaticProxy;

import java.lang.reflect.Proxy;

/**
 * @author ZhangJunqi
 * @Date 2021/12/4 -16:43
 */
public class HouseBuyer implements Buyer {
    //一个人要买房子
    public void buy() {
        System.out.println("要买房子");
    }

}
