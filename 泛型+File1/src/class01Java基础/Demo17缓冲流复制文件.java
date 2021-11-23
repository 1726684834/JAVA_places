package class01Java基础;

import java.io.*;

/**
 * @author ZhangJunqi
 * @Date 2021/10/20 -23:18
 */
public class Demo17缓冲流复制文件 {
    public static void main(String[] args) throws IOException {
        long startTime=System.currentTimeMillis ();
        String parent="D:\\IDEA\\JAVA_places\\泛型+File1\\src\\class01Java基础";
        BufferedInputStream bufferedInputStream = new BufferedInputStream (
                new FileInputStream (
                        new File (parent,"pic01.jpg")
                ));
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream (
                new FileOutputStream (
                        new File (parent,"pic5.jpg")
                ));
        //30秒
        /*int len=0;
        while ((len=bufferedInputStream.read ())!=-1){
            bufferedOutputStream.write (len);
        }*/
        //3秒
        byte[] bytes=new byte[1024];
        int len01=0;
        while ((len01=bufferedInputStream.read (bytes))!=-1){
            bufferedOutputStream.write (bytes,0,len01);
        }
        bufferedInputStream.close ();
        bufferedOutputStream.close ();
        long endTime=System.currentTimeMillis ();
        System.out.println ("复制时间="+(endTime-startTime)+"ms");

    }
}
