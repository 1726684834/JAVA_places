package class01线程;

/**
 * @author ZhangJunqi
 * @Date 2021/9/25 -20:52
 * 多个人做一个任务
 */
public class Demo02Runnable {
    //Synchronized锁升级和线程池
    public static void main(String[] args) {
        XianCheng02 bz=new XianCheng02 ();//只是一个线程任务对象，不是一个线程对象
        //把任务交给多个执行
        /*Thread t1=new Thread (bz,"张三");
        Thread t2=new Thread (bz,"李四");
        Thread t3=new Thread (bz,"王五");
        t1.start ();
        t2.start ();
        t3.start ();*/
        new Thread (bz,"张三").start ();
        new Thread (bz,"李四").start ();
        new Thread (bz,"王五").start ();
    }
}
class XianCheng02 implements Runnable{
    public XianCheng02(){}
    private int count=10;
    public void run(){
        while (true){
            if(count<=0){
                break;
            }
            try {
                Thread.sleep (100);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
            //多线程操作同一个资源线程不安全了，数据紊乱  并发问题
            System.out.println(Thread.currentThread ().getName ().toString ()+"搬第"+count--+"块转");
            //Thread.currentThread ()返回对当前执行的线程对象的引用
        }
    };
}