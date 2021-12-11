package cn.com.zhang.Class07JDKDynamicProxy;

import cn.com.zhang.Class06StaticProxy.Buyer;

/**
 * @author ZhangJunqi
 * @Date 2021/12/4 -21:00
 */
public class HouseDepartmentProxy extends CompanyProxy{

    private void before() {
        System.out.println("帮顾客购买房子前的准备工作");
    }

    private void after() {
        System.out.println("买完房子后的工作：尾款等");
    }
}
