package cn.com.zhang.Class09ObserverPattern;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ZhangJunqi
 * @Date 2021/12/5 -17:28
 */
public class WechatObserverable implements Observerable{
    private List<Observer> observerList;
    private String information;

    public WechatObserverable() {
        observerList=new ArrayList<Observer> ();
    }

    public void addObserver(Observer observer) {
        observerList.add (observer);
        System.out.println("添加用户");
    }

    public void removeObserver(Observer observer) {
        if(observerList.size ()>0){
            observerList.remove (observer);
            System.out.println("删除用户");
        }
    }

    public void setInformation(String information){
        this.information=information;
        Date date=new Date ();
        notifyObserver (information,date);
    }

    public void notifyObserver(String information, Date updateDate) {
        for(Observer observer : observerList){
            observer.updateInformation (information,updateDate);
        }
    }

}
