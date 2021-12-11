package cn.com.zhang.Class07JDKDynamicProxy;

import cn.com.zhang.Class06StaticProxy.Buyer;
import cn.com.zhang.Class06StaticProxy.HouseBuyer;

/**
 * @author ZhangJunqi
 * @Date 2021/12/4 -21:04
 */
public class JDKDynamicTest {
    public static void main(String[] args) {
        Buyer houseByer=new HouseBuyer ();
        houseByer= (Buyer) new HouseDepartmentProxy ().getInstance (houseByer);
        houseByer.buy ();
    }
}
