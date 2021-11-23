package class01线程;

/**
 * @author ZhangJunqi
 * @Date 2021/10/30 -19:04
 */
public class Demo06Daemon {
    /*
    线程同步其实就是一种等待和制,多个需要同时访问
    此对象的线程进入这个对象的等待池形成队列,等待前面线程使用完毕，下一个线程再使用
*/
    public static void main(String[] args) {
        Thread daemon=new Thread (()->{
            while (true){
                try {
                    Thread.sleep (1000);
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
                System.out.println ("守护线程");
            }
        });
        daemon.setDaemon (true);
        daemon.start ();

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
        thread.start ();


    }
}
