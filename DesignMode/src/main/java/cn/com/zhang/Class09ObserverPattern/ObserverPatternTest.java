package cn.com.zhang.Class09ObserverPattern;

/**
 * @author ZhangJunqi
 * @Date 2021/12/5 -17:37
 */
public class ObserverPatternTest {
    public static void main(String[] args) {
        Observer observer01=new WechatObserver ("张三");
        Observer observer02=new WechatObserver ("李四");
        Observerable observerable=new WechatObserverable ();
        observerable.addObserver (observer01);
        observerable.addObserver (observer02);
        observerable.setInformation ("一个新的推送");
        observerable.removeObserver (observer01);
        observerable.setInformation ("又有一个新的推送");
    }
}
