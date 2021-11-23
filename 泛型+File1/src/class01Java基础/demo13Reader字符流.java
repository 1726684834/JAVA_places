package class01Java基础;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author ZhangJunqi
 * @Date 2021/10/16 -20:21
 */
public class demo13Reader字符流 {
        /*
        使用字节流读取中文文件
        1个中文
            GBK:占用两个字节
            UTF-8:占用3个字节
      */
        /*
        java.io.Reader:字符输入流,是字符输入流的最顶层的父类,定义了一些共性的成员方法,是一个抽象类

        共性的成员方法:
            int read() 读取单个字符并返回。
            int read(char[] cbuf)一次读取多个字符,将字符读入数组。
            void close() 关闭该流并释放与之关联的所有资源。

        java.io.FileReader extends InputStreamReader extends Reader
        FileReader:文件字符输入流
        作用:把硬盘文件中的数据以字符的方式读取到内存中

        构造方法:
            FileReader(String fileName)
            FileReader(File file)
            参数:读取文件的数据源
                String fileName:文件的路径
                File file:一个文件
            FileReader构造方法的作用:
                1.创建一个FileReader对象
                2.会把FileReader对象指向要读取的文件
        字符输入流的使用步骤:
            1.创建FileReader对象,构造方法中绑定要读取的数据源
            2.使用FileReader对象中的方法read读取文件
            3.释放资源
     */

    /*
        java.io.Writer:字符输出流,是所有字符输出流的最顶层的父类,是一个抽象类

        共性的成员方法:
            - void write(int c) 写入单个字符。
            - void write(char[] cbuf)写入字符数组。
            - abstract  void write(char[] cbuf, int off, int len)写入字符数组的某一部分,off数组的开始索引,len写的字符个数。
            - void write(String str)写入字符串。
            - void write(String str, int off, int len) 写入字符串的某一部分,off字符串的开始索引,len写的字符个数。
            - void flush()刷新该流的缓冲。把内存缓冲区中的数据,刷新到文件中
            - void close() 关闭此流：释放资源(会先把内存缓冲区中的数据刷新到文件中)

        java.io.FileWriter extends OutputStreamWriter extends Writer
        FileWriter:文件字符输出流
        作用:把内存中字符数据写入到文件中

        构造方法:
            FileWriter(File file)根据给定的 File 对象构造一个 FileWriter 对象。
            FileWriter(String fileName) 根据给定的文件名构造一个 FileWriter 对象。
            参数:写入数据的目的地
                String fileName:文件的路径
                File file:是一个文件
            构造方法的作用:
                1.会创建一个FileWriter对象
                2.会根据构造方法中传递的文件/文件的路径,创建文件
                3.会把FileWriter对象指向创建好的文件

        字符输出流的使用步骤(重点):
            1.创建FileWriter对象,构造方法中绑定要写入数据的目的地
            2.使用FileWriter中的方法write,把数据写入到内存缓冲区中(字符转换为字节的过程)
            3.使用FileWriter中的方法flush,把内存缓冲区中的数据,刷新到文件中
            4.释放资源(会先把内存缓冲区中的数据刷新到文件中)


            flush方法和close方法的区别
                - flush ：刷新缓冲区，流对象可以继续使用。
                - close:  先刷新缓冲区，然后通知系统释放资源。流对象不可以再被使用了。
     */
    public static void main(String[] args) throws IOException {
        File file01=new File ("D:\\IDEA\\JAVA_places\\泛型+File1\\src\\class01Java基础","file02.txt");
        FileWriter fileWriter=new FileWriter (file01,true);
        String str="woaini我爱你12345";
        fileWriter.write (str,0,str.length ());
        char[] chars={'a','b','c','d'};
        fileWriter.write (chars,0,4);
        Arrays.asList (new String []{"e","f","g"}).forEach(s-> {
            try {
                fileWriter.write (s+"\r\n");
            } catch (IOException e) {
                e.printStackTrace ();
            }
        });
        fileWriter.flush ();

        FileReader fileReader=new FileReader (file01);
        /*int len01=0;
        while ((len01=fileReader.read ())!=-1){
            System.out.print ((char)len01);
        }*/
        int len02=0;
        char[] chars01=new char[(int)file01.length ()];
        while ((len02=fileReader.read (chars01))!=-1){
            System.out.println (new String(chars01,0,len02));

        }
        fileWriter.close ();
        fileReader.close ();

    }
}
