package cn.com.zhang.Class09ObserverPattern;

import java.util.Date;

/**
 * @author ZhangJunqi
 * @Date 2021/12/5 -17:25
 */
public interface Observer {
    public void updateInformation(String information, Date updateDate);
    public void display();
}
