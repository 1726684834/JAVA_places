package class01Java基础;

import java.io.File;

/**
 * @author ZhangJunqi
 * @Date 2021/10/10 -22:42
 */
public class Demo08File {
    /*
    File类遍历(文件夹)目录功能
        - public String[] list() ：返回一个String数组，表示该File目录中的所有子文件或目录。
        - public File[] listFiles() ：返回一个File数组，表示该File目录中的所有的子文件或目录。

    注意:
        list方法和listFiles方法遍历的是构造方法中给出的目录
        如果构造方法中给出的目录的路径不存在,会抛出空指针异常
        如果构造方法中给出的路径不是一个目录,也会抛出空指针异常
        隐藏文件也可以看到
 */
    public static void main(String[] args) {
        File file01=new File ("D:\\IDEA\\JAVA_places\\泛型+File1\\src");
        show01(file01);
        System.out.println("---------");
        show02(file01);
        System.out.println("---------");
        //递归打印多级目录
        getAllFiles(file01);
        System.out.println("---------");
        //通过上面遍历的方法查找以.java结尾的文件
        selectFile(file01);
    }

    private static void selectFile(File file01) {
        File[] files=file01.listFiles ();
        for (File file : files) {
            if(file.isDirectory ()){
                selectFile (file);
            }else {
                if(file.getName ().toLowerCase ().endsWith (".java")){
                    System.out.println (file);
                }
                //可以查找某个文件是否存在
                if(file.getName ().toLowerCase ().equals ("file02.txt")){
                    System.out.println (file.getName ()+"存在------");
                }
            }
        }
    }

    private static void getAllFiles(File file01) {
        System.out.println (file01);
        File[] files=file01.listFiles ();
        for (File file : files) {
            if(file.isDirectory ()){
                getAllFiles (file);
            }else {
                System.out.println (file);
            }
        }
    }


    private static void show01(File file) {
        String[] list01=file.list ();
        for (String fileName : list01) {
            System.out.println (fileName);
        }
    }
    /*
        public File[] listFiles() ：返回一个File数组，表示该File目录中的所有的子文件或目录。
        遍历构造方法中给出的目录,会获取目录中所有的文件/文件夹,把文件/文件夹封装为File对象,多个File对象存储到File数组中
     */

    private static void show02(File file) {
        File[] list01=file.listFiles ();
        for (File fileName : list01) {
            System.out.println (fileName);
        }
    }
}
