package class02代理模式;

/**
 * @author ZhangJunqi
 * @Date 2021/10/28 -23:08
 */
/*
静态代理在使用时,需要定义接口或者父类,被代理对象与代理对象一起实现相同的接口或者是继承相同父类.
好处:
    代理对象可以做很多真实对象做不了的事情
    真实对象专注做自已的事情
 */

public class StaticProxy {
    public static void main(String[] args) {
        new Thread (()-> System.out.println ("lambda")).start ();
        new HelpBuy (new MyBuy ()).buy ();
    }
}

class MyBuy implements Buy {
    @Override
    public void buy() {
        System.out.println ("我要买东西");
    }
}

class HelpBuy implements Buy{
    private Buy target;

    public HelpBuy(Buy target) {
        this.target = target;
    }

    @Override
    public void buy() {
        befor();
        target.buy ();
        after();
    }

    private void after() {
        System.out.println ("买完东西收代买费");
    }

    private void befor() {
        System.out.println ("帮买东西");
    }
}
interface Buy{
    public void buy();
}