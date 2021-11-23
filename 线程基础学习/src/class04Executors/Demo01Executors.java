package class04Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZhangJunqi
 * @Date 2021/11/2 -23:05
 */
public class Demo01Executors {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool (10);
        executorService.execute (new MyThread ());
        executorService.execute (new MyThread ());
        executorService.execute (new MyThread ());
        executorService.execute (new MyThread ());
        executorService.execute (new MyThread ());
        executorService.shutdown();
    }

}
class MyThread extends Thread{
    @Override
    public void run() {

        System.out.println (Thread.currentThread ().getName ());
    }
}
