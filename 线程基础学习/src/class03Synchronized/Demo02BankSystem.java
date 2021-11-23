package class03Synchronized;

/**
 * @author ZhangJunqi
 * @Date 2021/10/31 -10:46
 */
//同时取钱存钱
public class Demo02BankSystem {
    public static void main(String[] args) {
        Account a = new Account();
        Save s = new Save(a);
        s.setName ("父亲");
        s.start();
        Fetch f = new Fetch(a);
        f.setName ("儿子");
        f.start();

    }

    static class Save extends Thread {
        private Account a;
        public Save(Account a) {
            this.a = a;
        }
        public void run() {
            for (int i = 1; i <= 10; i++) {
                synchronized(a) {
                    a.save (Thread.currentThread ().getName (), 1000);
                }

                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    static class Fetch extends Thread {
        private Account a;

        public Fetch(Account a) {
            this.a = a;
        }

        public void run() {

            for (int i = 1; i <= 10; i++) {
                synchronized(a) {
                    a.fetch (Thread.currentThread ().getName (), 1000);
                }
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}

class Account {
    private double balance;

    public double getBalance() {
        return this.balance;

    }

    //public synchronized void save
    //弱将整个银行的大方法声明为同步会影响效率
    public void save(String threadName, double bal) {
        System.out.println(threadName + "线程开始存款了，当前余额是" + getBalance());
        this.balance += bal;
        System.out.println(threadName + "线程开始结束了，当前余额是" + getBalance());
    }

    public void fetch(String threadName, double bal) {
        System.out.println(threadName + "线程开始取款了，当前余额是" + getBalance());
        if (bal <= this.balance) {
            this.balance -= bal;
            System.out.println(threadName + "线程取款结束了，当前余额是" + getBalance());
        } else {
            System.out.println("余额不足");
        }
    }

}
