package class01线程;

/**
 * @author ZhangJunqi
 * @Date 2021/10/27 -22:41
 */
//龟兔赛跑
public class Demo02RunnableTest01 {

    static class Race implements Runnable{
        //private String competitor;
        private static String winner;
        private boolean flag=true;
        private static int a=0;
        private static int b=0;
        @Override
        public void run() {
            try {
                //线程不安全模拟延时
                Thread.sleep (1);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
            //不能用competitor接收，因为并发问题会导致错误的
            //competitor=Thread.currentThread ().getName ();
            while(flag){
                if(Thread.currentThread ().getName ().equals ("兔子")){
                    a=a+2;
                    System.out.println (Thread.currentThread ().getName ()+"跑了第"+a+"步");
                    if(a%30==0){
                        try {
                            System.out.println ("兔子睡着啦");
                            Thread.sleep (1);
                        } catch (InterruptedException e) {
                            e.printStackTrace ();
                        }
                    }
                    if(a>=100){
                        winner=Thread.currentThread ().getName ();
                        System.out.println (Thread.currentThread ().getName ()+"赢了! 这时候乌龟跑了" +b+"步");
                        stop ();
                        break;
                    }
                }else if(Thread.currentThread ().getName ().equals ("乌龟")){
                    b=b+1;
                    System.out.println (Thread.currentThread ().getName ()+"跑了第"+b+"步");
                    if(b>=100){
                        System.out.println (Thread.currentThread ().getName ()+"赢了! 这时候兔子跑了" +a+"步");
                        winner=Thread.currentThread ().getName ();
                        stop ();
                        break;
                    }
                }

            }
        }
        public void stop(){
            this.flag=false;
            System.out.println ("线程停止");
        }
    }

    public static void main(String[] args) {
        Race race=new Race ();
        new Thread (race,"兔子").start ();
        new Thread (race,"乌龟").start ();
        System.currentTimeMillis ();
    }
}
