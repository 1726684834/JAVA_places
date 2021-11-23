package class01Java基础;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ZhangJunqi
 * @Date 2021/10/13 -23:15
 */
public class Demo10OutPutStream {
        /*
        java.io.OutputStream:字节输出流
            此抽象类是表示输出字节流的所有类的超类。

        定义了一些子类共性的成员方法:
            - public void close() ：关闭此输出流并释放与此流相关联的任何系统资源。
            - public void flush() ：刷新此输出流并强制任何缓冲的输出字节被写出。
            - public void write(byte[] b)：将 b.length字节从指定的字节数组写入此输出流。
            - public void write(byte[] b, int off, int len) ：从指定的字节数组写入 len字节，从偏移量 off开始输出到此输出流。
            - public abstract void write(int b) ：将指定的字节输出流。

        java.io.FileOutputStream extends OutputStream
        FileOutputStream:文件字节输出流
        作用:把内存中的数据写入到硬盘的文件中

        构造方法:
            FileOutputStream(String name)创建一个向具有指定名称的文件中写入数据的输出文件流。
            FileOutputStream(File file) 创建一个向指定 File 对象表示的文件中写入数据的文件输出流。
            参数:写入数据的目的
                String name:目的地是一个文件的路径
                File file:目的地是一个文件
            构造方法的作用:
                1.创建一个FileOutputStream对象
                2.会根据构造方法中传递的文件/文件路径,创建一个空的文件
                3.会把FileOutputStream对象指向创建好的文件

        写入数据的原理(内存-->硬盘)
            java程序-->JVM(java虚拟机)-->OS(操作系统)-->OS调用写数据的方法-->把数据写入到文件中

        字节输出流的使用步骤(重点):
            1.创建一个FileOutputStream对象,构造方法中传递写入数据的目的地
            2.调用FileOutputStream对象中的方法write,把数据写入到文件中
            3.释放资源(流使用会占用一定的内存,使用完毕要把内存清空,提供程序的效率)
     */
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream=new FileOutputStream ("D:\\IDEA\\JAVA_places\\泛型+File1\\src\\class01Java基础\\a.txt");
        /*
        一次写多个字节的方法:
            - public void write(byte[] b)：将 b.length字节从指定的字节数组写入此输出流。
            - public void write(byte[] b, int off, int len) ：从指定的字节数组写入 len字节，从偏移量 off开始输出到此输出流。
        */
        fileOutputStream.write (new byte[]{49,48,48});
        byte[] byte01={65,66,67,68,69};//ABCDE
        fileOutputStream.write (byte01,2,3);
        byte[] byte02="你好".getBytes ();//[-28, -67, -96, -27, -91, -67] UTF-8  三个字节一个中文  JDK是两个
        //System.out.println(Arrays.toString (byte02));//把字符串转换为字节数组
        /*
            public void write(byte[] b)：将 b.length字节从指定的字节数组写入此输出流。
            一次写多个字节:
                如果写的第一个字节是正数(0-127),那么显示的时候会查询ASCII表
                如果写的第一个字节是负数,那第一个字节会和第二个字节,两个字节组成一个中文显示,查询系统默认码表(GBK)
         */
        fileOutputStream.write (byte02);
        fileOutputStream.close ();

        System.out.println("--------------------");

        /*
        追加写/续写:使用两个参数的构造方法
            FileOutputStream(String name, boolean append)创建一个向具有指定 name 的文件中写入数据的输出文件流。
            FileOutputStream(File file, boolean append) 创建一个向指定 File 对象表示的文件中写入数据的文件输出流。
            参数:
               String name,File file:写入数据的目的地
               boolean append:追加写开关
                true:创建对象不会覆盖源文件,继续在文件的末尾追加写数据
                false:创建一个新文件,覆盖源文件
        写换行:写换行符号
            windows:\r\n
            linux:/n
            mac:/r
        */
        File file=new File ("D:\\IDEA\\JAVA_places\\泛型+File1\\src\\class01Java基础\\","file02.txt");
        //System.out.println (file.exists ());
        if(file.exists ()){
            FileOutputStream outPut02=new FileOutputStream (file,true);
            for (int i = 0; i < 10; i++) {
                outPut02.write ("Love you".getBytes ());
                outPut02.write ("\r\n".getBytes ());
            }
            outPut02.close ();

        }else{
            System.out.println("file不存在");
        }

    }
}

