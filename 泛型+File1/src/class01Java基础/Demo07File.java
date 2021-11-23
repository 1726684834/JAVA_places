package class01Java基础;

import java.io.File;
import java.io.IOException;

/**
 * @author ZhangJunqi
 * @Date 2021/10/10 -15:47
 */
public class Demo07File {
    /*
    File类判断功能的方法
        - public boolean exists() ：此File表示的文件或目录是否实际存在。
        - public boolean isDirectory() ：此File表示的是否为目录。
        - public boolean isFile() ：此File表示的是否为文件。
    */

    private static void show01() {
        File file01=new File ("D:\\IDEA\\JAVA_places\\泛型+File1\\src\\file01.txt");
        System.out.println ("file01.exists () = " + file01.exists ());//true
        if(file01.exists ()){
            System.out.println ("file01.isDirectory () = " + file01.isDirectory ());//false
            System.out.println ("file01.isFile () = " + file01.isFile ());//true
        }
    }


    /*
        File类创建删除功能的方法
            - public boolean createNewFile() ：当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。需抛出异常
            - public boolean delete() ：删除由此File表示的文件或目录。
            - public boolean mkdir() ：创建由此File表示的目录。单级文件夹
            - public boolean mkdirs() ：创建由此File表示的目录，包括任何必需但不存在的父目录。既可以创建单级空文件夹,也可以创建多级文件夹
     */

    //public boolean createNewFile()
    private static void show02() throws IOException {
        File file02=new File ("泛型+File1\\src\\file03.txt");
        boolean b1=file02.createNewFile ();
        System.out.println ("b1 = " + b1);
        System.out.println (file02.getAbsolutePath ());

        File file03=new File ("D:\\IDEA\\JAVA_places\\泛型+File1\\src\\file04.txt");
        boolean b2=file03.createNewFile ();
        System.out.println ("b2 = " + b2);

        File file04=new File ("D:\\IDEA\\JAVA_places\\泛型+File1\\src\\新建文件夹");
        boolean b3=file04.createNewFile ();
        System.out.println ("b3 = " + b3);

    }

    //mkdirs
    private static void show03() {
        File file05 =new File ("泛型+File1\\src\\aaa");
        boolean b4=file05.mkdir ();
        System.out.println ("b4 = " + b4);
        File file06=new File ("泛型+File1\\src\\bbb\\ccc\\ddd");
        boolean b5=file06.mkdirs ();
        System.out.println ("b5 = " + b5);
    }

    /*
       public boolean delete() ：删除由此File表示的文件或目录。
       此方法,可以删除构造方法路径中给出的文件/文件夹
       返回值:布尔值
           true:文件/文件夹删除成功,返回true
           false:文件夹中有内容,不会删除返回false;构造方法中路径不存在false
       注意:
           delete方法是直接在硬盘删除文件/文件夹,不走回收站,删除要谨慎
    */
    private static void show04() {
        File file07=new File ("D:\\IDEA\\JAVA_places\\泛型+File1\\src\\新建文件夹");
        boolean b6=file07.delete ();
        System.out.println ("b6 = " + b6);
    }
    public static void main(String[] args) throws IOException {
        show01();
        System.out.println("--------");
        show02();
        System.out.println("--------");
        show03();
        System.out.println("--------");
        show04();
    }

}
