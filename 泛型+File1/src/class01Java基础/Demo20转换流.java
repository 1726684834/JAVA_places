package class01Java基础;

import java.io.*;

/**
 * @author ZhangJunqi
 * @Date 2021/10/23 -19:14
 */
public class Demo20转换流 {
    /*
    FileReader可以读取IDE默认编码格式(UTF-8)的文件
    FileReader读取系统默认编码(中文GBK)会产生乱码���

    java.io.OutputStreamWriter extends Writer
    OutputStreamWriter: 是字符流通向字节流的桥梁：可使用指定的 charset 将要写入流中的字符编码成字节。(编码:把能看懂的变成看不懂)

    构造方法:
        OutputStreamWriter(OutputStream out)创建使用默认字符编码的 OutputStreamWriter。
        OutputStreamWriter(OutputStream out, String charsetName) 创建使用指定字符集的 OutputStreamWriter。
        参数:
            OutputStream out:字节输出流,可以用来写转换之后的字节到文件中
            String charsetName:指定的编码表名称,不区分大小写,可以是utf-8/UTF-8,gbk/GBK,...不指定默认使用UTF-8
    */
    public static void main(String[] args) throws IOException {
//        write_gbk();
//        read_gbk();
        gbkToUTF8();
    }

    private static void read_gbk() throws IOException {
        InputStreamReader inputStreamReader=new InputStreamReader (new FileInputStream (new File ("泛型+File1\\src\\class01Java基础\\gbk文档.txt")),"GBK");
        int len=0;
        while ((len=inputStreamReader.read ())!=-1){
            System.out.println ((char)len);
        }
        inputStreamReader.close ();
    }

    private static void write_gbk() throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream ("泛型+File1\\src\\class01Java基础\\gbk文档.txt",true),"GBK");
        outputStreamWriter.write("你好");
        outputStreamWriter.flush();
        outputStreamWriter.close();
    }

    private static void gbkToUTF8() throws IOException{
        File file01=new File ("泛型+File1\\src\\class01Java基础\\gbk文档.txt");
        File file02=new File ("泛型+File1\\src\\class01Java基础\\gbkToUtf8文档.txt");
        InputStreamReader inputStreamReader=new InputStreamReader (new FileInputStream (file01),"GBK");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream (file02,true),"utf-8");
        int len=0;
        while ((len=inputStreamReader.read ())!=-1){
            outputStreamWriter.write (len);
        }
        inputStreamReader.close ();
        outputStreamWriter.close();
    }
}
