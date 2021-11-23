package class01Java基础;

import java.io.*;

/**
 * @author ZhangJunqi
 * @Date 2021/10/20 -22:50
 */
public class Demo16字节缓冲流 {
    /*
    java.io.BufferedOutputStream extends OutputStream
    BufferedOutputStream:字节缓冲输出流

    继承自父类的共性成员方法:
        - public void close() ：关闭此输出流并释放与此流相关联的任何系统资源。
        - public void flush() ：刷新此输出流并强制任何缓冲的输出字节被写出。
        - public void write(byte[] b)：将 b.length字节从指定的字节数组写入此输出流。
        - public void write(byte[] b, int off, int len) ：从指定的字节数组写入 len字节，从偏移量 off开始输出到此输出流。
        - public abstract void write(int b) ：将指定的字节输出流。

     构造方法:
        BufferedOutputStream(OutputStream out)  创建一个新的缓冲输出流，以将数据写入指定的底层输出流。
        BufferedOutputStream(OutputStream out, int size)  创建一个新的缓冲输出流，以将具有指定缓冲区大小的数据写入指定的底层输出流。
        参数:
           OutputStream out:字节输出流
                我们可以传递FileOutputStream,缓冲流会给FileOutputStream增加一个缓冲区,提高FileOutputStream的写入效率
           int size:指定缓冲流内部缓冲区的大小,不指定默认
     */
    public static void main(String[] args) throws IOException {
        FileOutputStream fos=new FileOutputStream ("D:\\IDEA\\JAVA_places\\泛型+File1\\src\\class01Java基础\\file01.txt",true);

        BufferedOutputStream bos=new BufferedOutputStream (fos);
        bos.write ("\r\n".getBytes ());
        bos.write ("今天很充实哦".getBytes ());
        bos.flush ();
        //关闭只需要关闭缓冲流，因为他会自动关闭字节流
        bos.close ();


    /*
        java.io.BufferedInputStream extends InputStream
        BufferedInputStream:字节缓冲输入流

        继承自父类的成员方法:
            int read()从输入流中读取数据的下一个字节。
            int read(byte[] b) 从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中。
            void close() 关闭此输入流并释放与该流关联的所有系统资源。

        构造方法:
            BufferedInputStream(InputStream in) 创建一个 BufferedInputStream 并保存其参数，即输入流 in，以便将来使用。
            BufferedInputStream(InputStream in, int size) 创建具有指定缓冲区大小的 BufferedInputStream 并保存其参数，即输入流 in，以便将来使用。
            参数:
                InputStream in:字节输入流
                    我们可以传递FileInputStream,缓冲流会给FileInputStream增加一个缓冲区,提高FileInputStream的读取效率
                int size:指定缓冲流内部缓冲区的大小,不指定默认

        使用步骤(重点):
            1.创建FileInputStream对象,构造方法中绑定要读取的数据源
            2.创建BufferedInputStream对象,构造方法中传递FileInputStream对象,提高FileInputStream对象的读取效率
            3.使用BufferedInputStream对象中的方法read,读取文件
            4.释放资源
    */
        BufferedInputStream bis=new BufferedInputStream (new FileInputStream ("D:\\IDEA\\JAVA_places\\泛型+File1\\src\\class01Java基础\\file01.txt"));
        byte[] bytes = new byte[1024];//从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中。
        int len=0;
        while ((len=bis.read (bytes))!=-1){
            System.out.println(len+" -"+"\n"+new String (bytes,0,len));
        }
        bis.close ();
    }
}
