package class03Synchronized;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ZhangJunqi
 * @Date 2021/11/1 -22:25
 */
public class Demo03Lock {
    public static void main(String[] args) {
        TicketLock ticketLock=new TicketLock ();
        new Thread (ticketLock).start ();
        new Thread (ticketLock).start ();
        new Thread (ticketLock).start ();
    }

}
class TicketLock implements Runnable{
    private int tickes=10;
    private ReentrantLock lock = new ReentrantLock ();
    @Override
    public void run() {
        while (true){
            try {
                lock.lock ();
                Thread.sleep (1000);
                if (tickes<=0){
                    break;
                }
                System.out.println (tickes--);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            } finally {
                lock.unlock ();
            }

        }
    }
}