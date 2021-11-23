package class01线程;

/**
 * @author ZhangJunqi
 * @Date 2021/9/25 -20:18
 * 多个人同时做多个任务
 */

public class Demo01Thread {
    public static void main(String[] args) {
        XianCheng01 hangman=new XianCheng01 ("张三");
        XianCheng01 lisi=new XianCheng01 ("李四");
        XianCheng01 wangwu=new XianCheng01 ("王五");
        lisi.start ();
        hangman.start ();
        wangwu.start ();
    }
}
class XianCheng01 extends Thread{
    private String name;
    public XianCheng01(){}
    public XianCheng01(String name) {
        this.name = name;
    }
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(name+"搬第"+(i+1)+"快转");
        }
    };
}