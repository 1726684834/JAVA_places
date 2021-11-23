package class01线程;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * @author ZhangJunqi
 * @Date 2021/10/28 -22:27
 */
public class Demo03Callable implements Callable<Boolean> {
    private String url;
    private String fileName;

    public Demo03Callable(String url, String fileName) {
        this.url = url;
        this.fileName = fileName;
    }

    @Override
    public Boolean call() throws Exception {
        DownPic downPic=new DownPic ();
        downPic.downUrlToFile (url,fileName);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Demo03Callable callable01=new Demo03Callable ("http://p9.qhimg.com/t016c3b1e83b23c3bd6.jpg","线程学习\\src\\class01线程\\mn04.jpg");
        Demo03Callable callable02=new Demo03Callable ("https://b-ssl.duitang.com/uploads/item/201901/08/20190108235903_lhscr.jpg","线程学习\\src\\class01线程\\mn05.jpg");
        Demo03Callable callable03=new Demo03Callable ("http://5b0988e595225.cdn.sohucs.com/images/20190921/948dda504bb44b2380581893530dc3e9.jpeg","线程学习\\src\\class01线程\\mn06.jpg");
        //FutureTask接收 new Thread().start(); 也可以
        // new Thread (new FutureTask(callable01)).start ();
        ExecutorService executorService= Executors.newFixedThreadPool (3);
        Future<Boolean> future01=executorService.submit (callable01);
        Future<Boolean> future02=executorService.submit (callable02);
        Future<Boolean> future03=executorService.submit (callable03);
        boolean b1=future01.get ();
        boolean b2=future02.get ();
        boolean b3=future03.get ();
        System.out.println (b1+" "+b2+" "+b3);
        executorService.shutdownNow ();
    }

    class DownPic{
        private String url;
        private String fileName;

        public DownPic() { }

        public DownPic(String url, String fileName) {
            this.url = url;
            this.fileName = fileName;
        }
        public void downUrlToFile(String url,String fileName) throws IOException {
            FileUtils.copyURLToFile (new URL (url),new File (fileName));
        };

    }
}
