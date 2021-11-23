package class03Synchronized;

/**
 * @author ZhangJunqi
 * @Date 2021/11/1 -22:54
 */
/*
生产者消费者模型-->缓冲区解决：
    (1)管乘法：生产者和消费者之间有个缓冲区
    (2)信号灯法：放一个标志位 如boolean类型

*/


public class Demo04PC01 {
    public static void main(String[] args) {
        Container container=new Container ();
        new Producer(container).start();
        new Customer (container).start ();
    }
}

class Producer extends Thread{
    public Container container;

    public Producer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            try {
                Thread.sleep (100);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
            if(container.push (new Product (i))){
                System.out.println ("生产第"+i+"件产品");
            }
        }
    }

}

class Customer extends Thread{
    Container container;

    public Customer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            try {
                Thread.sleep (100);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
            int a=container.pos ().num;
            System.out.println ("消费了第"+a+"件产品");
        }
    }

}

class Container{
    private Product[] products=new Product[10];
    int count=0;

    public synchronized boolean push(Product product){
        System.out.println ("pushcount = " + count);
        while (count>=products.length){
            System.out.println ("容器已满，生产停止，等待消费者消费");
            try {
                this.wait ();
            }catch (InterruptedException e){
                e.printStackTrace ();
            }
        }
        products[count]=product;
        count++;
        this.notifyAll ();
        return true;
    }

    public synchronized Product pos(){
        System.out.println ("poscount = " + count);
        while (count==0){
            System.out.println ("容器已空，等待生产者生产");
            try {
                this.wait ();
            }catch (InterruptedException e){
                e.printStackTrace ();
            }
        }
        count--;
        Product product=products[count];
        this.notifyAll ();
        return product;
    }
}

class Product{
    int num;

    public Product(int num) {
        this.num = num;
    }
}
