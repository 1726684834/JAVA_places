package class01Java基础;

import java.io.File;

/**
 * @author ZhangJunqi
 * @Date 2021/10/9 -6:09
 */
/*
    java.io.file类：文件和目录路径名的抽象表示形式
    java把电脑中的文件和目录封装一个file类，我们可以调用file类对文件和目录进行操作
    我们可以使用File类的方法
        创建一个文件/文件夹
        删除文件/文件夹
        获取文件/文件夹
        判断文件/文件夹是否存在
        对文件夹进行遍历
        获取文件的大小
    File类是一个与系统无关的类,任何的操作系统都可以使用这个类中的方法
    重点:记住这三个单词
        file:文件
        directory:文件夹/目录
        path:路径
*/
public class Demo06File {
    public static void main(String[] args) {
        /*
            File类的静态成员变量：
            static String pathSeparator 与系统有关的路径分隔符，为了方便，它被表示为一个字符串。
            static char pathSeparatorChar 与系统有关的路径分隔符。

            static String separator 与系统有关的默认名称分隔符，为了方便，它被表示为一个字符串。
            static char separatorChar 与系统有关的默认名称分隔符。
         */
        //路径分隔符，Windows是分号 ;  linux是冒号 :
        String pathSeparator=File.pathSeparator;
        System.out.println("1"+pathSeparator);

        //文件名称分隔符 windows:反斜杠\  linux:正斜杠/
        String separator = File.separator;
        System.out.println("2"+separator);

        //File类的构造方法：
        show01();
        show02("C:\\","a.txt");
        show03 ();

        /*
        File类获取功能的方法
            - public String getAbsolutePath() ：返回此File的绝对路径名字符串。
                 无论路径是绝对的还是相对的,getAbsolutePath方法返回的都是绝对路径
            - public String getPath() ：将此File转换为路径名字符串。
            - public String getName()  ：返回由此File表示的文件或目录的名称。
                获取的就是构造方法传递路径的结尾部分(文件/文件夹)
            - public long length()  ：返回由此File表示的文件的长度。
                获取的是构造方法指定的文件的大小,以字节为单位
                注意:
                    文件夹是没有大小概念的,不能获取文件夹的大小
                    如果构造方法中给出的路径不存在,那么length方法返回0
                    文件夹没有大小概念也是0
         */
        File file01=new File ("D:\\IDEA\\JAVA_places\\泛型学习\\src\\file01.txt");
        System.out.println("6"+file01.getAbsolutePath ());

        File file02=new File ("class01Java基础/file01.txt");
        System.out.println ("7"+file02.getAbsolutePath ());

        System.out.println(file01.getPath ());
        System.out.println ("8"+file02.getPath ());
        //toString()调用的就是getPath()方法
        System.out.println("9"+file01.toString ());

        File file03=new File ("D:\\IDEA\\JAVA_places\\泛型学习\\src");
        System.out.println(file01.getName ());
        System.out.println(file03.getName ());

        File file04=new File ("D:\\IDEA\\JAVA_places\\泛型学习\\src\\picture01.png");
        System.out.println(file04.length ());

    }

    /*
       File(String pathname) 通过将给定路径名字符串转换为抽象路径名来创建一个新 File 实例。
       参数:
           String pathname:字符串的路径名称
           路径可以是以文件结尾,也可以是以文件夹结尾
           路径可以是相对路径,也可以是绝对路径
           路径可以是存在,也可以是不存在
           创建File对象,只是把字符串路径封装为File对象,不考虑路径的真假情况
    */
    private static void show01() {
        File file=new File ("D:\\IDEA\\JAVA_places\\泛型学习\\src\\file01.txt");
        System.out.println("3"+file);
    }

    /*
        File(String parent, String child) 根据 parent 路径名字符串和 child 路径名字符串创建一个新 File 实例。
        参数:把路径分成了两部分
            String parent:父路径
            String child:子路径
        好处:
            父路径和子路径,可以单独书写,使用起来非常灵活;父路径和子路径都可以变化
     */
    private static void show02(String parent, String child) {
        File file=new File (parent,child);
        System.out.println ("4"+file);
    }

    /*
        File(File parent, String child) 根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例。
        参数:把路径分成了两部分
            File parent:父路径
            String child:子路径
        好处:
             父路径和子路径,可以单独书写,使用起来非常灵活;父路径和子路径都可以变化
             父路径是File类型,可以使用File的方法对路径进行一些操作,再使用路径创建对象
     */
    private static void show03() {
        File parent = new File("c:\\");
        File file = new File(parent,"hello.java");
        System.out.println("5"+file);//c:\hello.java
    }
}
