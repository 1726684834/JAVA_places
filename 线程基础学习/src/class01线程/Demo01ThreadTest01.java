package class01线程;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;


/**
 * @author ZhangJunqi
 * @Date 2021/10/26 -23:04
 */
public class Demo01ThreadTest01 extends Thread{
    private String url;
    private String fileName;

    public Demo01ThreadTest01(String url, String fileName) {
        this.url = url;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        WebDownload webDownload=new WebDownload ();
        webDownload.downloadPic (url,fileName);
        System.out.println ("下载"+fileName);
    }

    public static void main(String[] args) {
        Demo01ThreadTest01 threadTest01=new Demo01ThreadTest01 ("http://www.sinaimg.cn/dy/slidenews/39_img/2012_41/22496_1331632_969432.jpg",
                "线程学习\\src\\class01线程\\mn01.jpg");
        Demo01ThreadTest01 threadTest02=new Demo01ThreadTest01 ("http://album.u17i.com/image/2011/01/04/fc/5088_547_14083_VM42.jpg",
                "线程学习\\src\\class01线程\\mn02.jpg");
        Demo01ThreadTest01 threadTest03=new Demo01ThreadTest01 ("http://www.sinaimg.cn/dy/slidenews/39_img/2012_39/22496_1320262_823963.jpg",
                "线程学习\\src\\class01线程\\mn03.jpg");
        threadTest01.start ();
        threadTest02.start ();
        threadTest03.start ();

    }

    class WebDownload{
        public WebDownload() {
        }
        public  void downloadPic (String url, String fileName){
            try {
                FileUtils.copyURLToFile (new URL (url),new File (fileName));
            } catch (IOException e) {
                e.printStackTrace ();
            }
        };
        
    }//
    //
    //
}
