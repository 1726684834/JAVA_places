package class01Java基础;

import java.io.*;

/**
 * @author ZhangJunqi
 * @Date 2021/10/16 -19:56
 */
public class Demo12文件复制 {

    public static void main(String[] args) throws IOException {
        long startTime=System.currentTimeMillis ();
        String parent="D:\\IDEA\\JAVA_places\\泛型+File1\\src\\class01Java基础";
        File file01=new File (parent,"pic01.jpg");
        File file02=new File (parent,"pic02.jpg");
        FileInputStream fileInputStream=new FileInputStream (file01);
        FileOutputStream fileOutputStream=new FileOutputStream (file02,true);
        //复制花费7776
        /*int len=0;
        while ((len=fileInputStream.read ())!=-1){
            fileOutputStream.write (len);
        }*/
        //花费8ms
        byte[] bytes = new byte[1024];
        int len01=0;
        while ((len01=fileInputStream.read (bytes))!=-1){
            fileOutputStream.write (bytes,0,len01);
        }
        fileInputStream.close ();
        fileOutputStream.close ();
        long endTime=System.currentTimeMillis ();
        System.out.println ("花费 = " + (endTime-startTime));
    }
}
