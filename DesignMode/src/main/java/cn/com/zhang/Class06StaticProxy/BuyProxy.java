package cn.com.zhang.Class06StaticProxy;

import java.lang.reflect.Proxy;

/**
 * @author ZhangJunqi
 * @Date 2021/12/4 -16:45
 */
public class BuyProxy implements Buyer {
    private Buyer buyer;

    public BuyProxy(Buyer buyer) {
        this.buyer = buyer;
    }

    public void buy() {
        System.out.println("代理客户买房子前的操作");
        buyer.buy ();
        System.out.println("办理后操作");
    }
}
