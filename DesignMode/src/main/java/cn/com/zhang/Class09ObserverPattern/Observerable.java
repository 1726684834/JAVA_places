package cn.com.zhang.Class09ObserverPattern;

import java.util.Date;

/**
 * @author ZhangJunqi
 * @Date 2021/12/5 -17:26
 */
//被观察者接口。定义添加、删除、通知观察者的抽象方法
public interface Observerable {
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void setInformation(String information);
    public void notifyObserver(String information, Date updateDate);
}
