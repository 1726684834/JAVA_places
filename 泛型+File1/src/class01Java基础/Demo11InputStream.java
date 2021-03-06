package class01Java基础;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author ZhangJunqi
 * @Date 2021/10/14 -22:45
 */
public class Demo11InputStream {
        /*
        java.io.InputStream:字节输入流。此抽象类是表示字节输入流的所有类的超类。
        定义了所有子类共性的方法:
             int read()从输入流中读取数据的下一个字节。
             int read(byte[] b) 从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中。
             void close() 关闭此输入流并释放与该流关联的所有系统资源。

        java.io.FileInputStream extends InputStream
        FileInputStream:文件字节输入流
        作用:把硬盘文件中的数据,读取到内存中使用

        构造方法:
            FileInputStream(String name)
            FileInputStream(File file)
            参数:读取文件的数据源
                String name:文件的路径
                File file:文件
            构造方法的作用:
                1.会创建一个FileInputStream对象
                2.会把FileInputStream对象指定构造方法中要读取的文件

        读取数据的原理(硬盘-->内存)
            java程序-->JVM-->OS-->OS读取数据的方法-->读取文件

        字节输入流的使用步骤(重点):
            1.创建FileInputStream对象,构造方法中绑定要读取的数据源
            2.使用FileInputStream对象中的方法read,读取文件
            3.释放资源
     */
    public static void main(String[] args) throws IOException {
        File file01=new File ("D:\\IDEA\\JAVA_places\\泛型+File1\\src\\class01Java基础\\","file02.txt");
        FileInputStream inputStream01 = new FileInputStream (file01);
        int len=0;
        while ((len=inputStream01.read ()) != -1){
            System.out.print ((char) len);
        }
        /*输出：
            Love you
            Love you
        */
        inputStream01.close ();

        System.out.println("-------");
    /*
        字节输入流一次读取多个字节的方法:
            int read(byte[] b) 从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中。
        明确两件事情:
            1.方法的参数byte[]的作用?
                起到缓冲作用,存储每次读取到的多个字节
                数组的长度一把定义为1024(1kb)或者1024的整数倍
            2.方法的返回值int是什么?
                每次读取的有效字节个数

        String类的构造方法
            String(byte[] bytes) :把字节数组转换为字符串
            String(byte[] bytes, int offset, int length) 把字节数组的一部分转换为字符串 offset:数组的开始索引 length:转换的字节个数
     */
        File file02=new File ("D:\\IDEA\\JAVA_places\\泛型+File1\\src\\class01Java基础\\","a.txt");
        FileInputStream inputStream02=new FileInputStream (file02);
        /*byte[] bytes=new byte[2];
        int len1=inputStream02.read (bytes);
        System.out.println (len1+" "+(new String(bytes)));
        len1=inputStream02.read (bytes);
        System.out.println (len1+" "+(new String(bytes)));
        len1=inputStream02.read (bytes);
        System.out.println (len1+" "+(new String(bytes)));*/
       /* 输出：
        2 AB
        2 CD
        1 ED
        */
        byte[] byte02=new byte[1024];
        int len02=0;
        while ((len02=inputStream02.read (byte02))!=-1){
            System.out.println(len02+" - "+new String (byte02,0,len02));
        }
        inputStream02.close ();
    }
}
