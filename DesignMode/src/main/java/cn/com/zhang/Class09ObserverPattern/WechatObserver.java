package cn.com.zhang.Class09ObserverPattern;

import java.util.Date;

/**
 * @author ZhangJunqi
 * @Date 2021/12/5 -17:34
 */
public class WechatObserver implements Observer{
    private String name;
    private String information;
    private Date updateDate;

    public WechatObserver(String name) {
        this.name = name;
    }

    public void updateInformation(String information, Date updateDate) {
        this.information=information;
        this.updateDate=updateDate;
        display();
    }

    public void display() {
        System.out.println(name+"收到的消息是："+information+" 时间："+updateDate);
    }
}
