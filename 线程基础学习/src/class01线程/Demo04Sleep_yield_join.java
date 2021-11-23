package class01线程;

/**
 * @author ZhangJunqi
 * @Date 2021/10/30 -14:32
 */
public class Demo04Sleep_yield_join {
    static class SleepThread implements Runnable{
        @Override
        public void run() {
            //倒计时
            int a=10;
            while (a>=0){
                try {
                    System.out.println (a);
                    Thread.sleep (1000);
                    a--;
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        }
    }

    static class YieldThread implements Runnable{
       /*
       线程礼让,让当前正在执行的线程暂停，但不阻塞将线程从运行状态转为就绪状态
        让cpu重新调度，礼让不一定成功!看CPU心情
        */

        @Override
        public void run() {
            System.out.println (Thread.currentThread ().getName ()+"开始");
            Thread.yield ();//礼让
            System.out.println (Thread.currentThread ().getName ()+"结束");
        }
    }

    static class JoinThread implements Runnable{
        //Join合并线程，待此线程执行完成后，再执行其他线程，其他线程阻塞，相当于插队

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println ("Thread " + i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        YieldThread yieldThread=new YieldThread ();
        new Thread (yieldThread,"a").start ();
        new Thread (yieldThread,"b").start ();

        Thread JoinThread=new Thread (new JoinThread ());
        JoinThread.start ();
        for (int i = 0; i < 5; i++) {
            System.out.println ("Main" + i);
            if(i==2){
                JoinThread.join ();
            }
        }
        //10秒倒计时
        //new Thread (new SleepThread ()).start ();

        //通过倒计时查看线程状态
        Thread thread=new Thread (()->{
            for (int i = 10; i >=0; i--) {
                try {
                    System.out.println (i);
                    Thread.sleep (1000);
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        });
        System.out.println (thread.getState ());
        thread.start ();
        while (thread.getState ()!= Thread.State.TERMINATED){
            Thread.sleep (500);
            System.out.println ("Thread-state"+thread.getState ());
        }
    }
}
