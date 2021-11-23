package class01Java基础;

import java.io.*;
import java.util.Arrays;

/**
 * @author ZhangJunqi
 * @Date 2021/10/23 -14:20
 */
public class Demo18字符缓冲流 {
    /*
        java.io.BufferedWriter extends Writer
         BufferedWriter:字符缓冲输出流
           构造方法:
        BufferedWriter(Writer out) 创建一个使用默认大小输出缓冲区的缓冲字符输出流。
        BufferedWriter(Writer out, int sz) 创建一个使用给定大小输出缓冲区的新缓冲字符输出流。
        参数:
            Writer out:字符输出流
                我们可以传递FileWriter,缓冲流会给FileWriter增加一个缓冲区,提高FileWriter的写入效率
            int sz:指定缓冲区的大小,不写默认大小

        特有的成员方法:
            void newLine() 写入一个行分隔符。会根据不同的操作系统,获取不同的行分隔符
            换行:换行符号
            windows:\r\n
            linux:/n
            mac:/r
     */

    /*
        java.io.BufferedReader extends Reader
        BufferedReader:字符缓冲输入流
         构造方法:
            BufferedReader(Reader in)  创建一个使用默认大小输入缓冲区的缓冲字符输入流。
            BufferedReader(Reader in, int sz)     创建一个使用指定大小输入缓冲区的缓冲字符输入流。
            参数:
                Reader in:字符输入流
                    我们可以传递FileReader,缓冲流会给FileReader增加一个缓冲区,提高FileReader的读取效率
         特有的成员方法:
            String readLine() 读取一个文本行。
            读取一行数据行的终止符号:通过下列字符之一即可认为某行已终止：换行 ('\n')、回车 ('\r') 或回车后直接跟着换行(\r\n)。
            返回值:包含该行内容的字符串，不包含任何行终止符，如果已到达流末尾，则返回 null
     */
    public static void main(String[] args) throws IOException {
        File file=new File ("泛型+File1\\src\\file03.txt");

        BufferedWriter bufferedWriter = new BufferedWriter (new FileWriter (file,true));
        String[] strs=new String[]{"I like learn;","I want to make more money"};
        Arrays.asList (strs).forEach (str->{
            try {
                bufferedWriter.write (str);
                bufferedWriter.newLine ();
            } catch (IOException e) {
                e.printStackTrace ();
            }
        });
        //对写入的进行
        bufferedWriter.flush ();
        BufferedReader bufferedReader=new BufferedReader (new FileReader (file));
        String str;
        while ((str=bufferedReader.readLine ())!=null){
            System.out.println (str);
        }
        bufferedWriter.close ();
        bufferedReader.close ();
    }
}
