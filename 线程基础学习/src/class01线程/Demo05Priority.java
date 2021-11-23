package class01线程;

/**
 * @author ZhangJunqi
 * @Date 2021/10/30 -17:39
 */
public class Demo05Priority {
    /*
    * 主线程优先级最高
    *Java提供一个线程调度器来监控程序中启动后进入就绪状态的所有线程，线程调度器按照优先级决定应该调度哪个线程来执行。
    * Thread.MIN_PRIORITY = 1;
    * Thread.MAX_PRIORITY= 10;
    * Thread.NORM_PRIORITY = 5;
    * 优先级低只是意味着获得调度的概率低.并不是优先级低就不会被调用了.这都是看CPU的调度
    * getPriority() . setPriority(int xxx)
    * 优先级的设定建议在start()调度前
    * */
    public static void main(String[] args) {
        PriorityThread priorityThread=new PriorityThread ();
        System.out.println (Thread.currentThread ().getName ()+" -主线程优先级"+Thread.currentThread ().getPriority ());
        Thread threadA=new Thread (priorityThread,"a");
        Thread threadB=new Thread (priorityThread,"b");
        Thread threadC=new Thread (priorityThread,"c");
        Thread threadD=new Thread (priorityThread,"d");
        Thread threadE=new Thread (priorityThread,"e");
        threadA.start ();

        threadB.setPriority (Thread.MIN_PRIORITY);
        threadB.start ();

        threadC.setPriority (Thread.MAX_PRIORITY);
        threadC.start ();

        threadD.setPriority (5);
        threadD.start ();

        threadE.setPriority (7);
        threadE.start ();
    }
}
class PriorityThread implements Runnable{
    @Override
    public void run() {
        System.out.println (Thread.currentThread ().getName ()+" -优先级"+Thread.currentThread ().getPriority ());
    }
}
