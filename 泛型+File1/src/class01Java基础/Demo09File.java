package class01Java基础;

import java.io.File;

/**
 * @author ZhangJunqi
 * @Date 2021/10/11 -23:28
 */
public class Demo09File {
    //简化遍历file文件
    public static void main(String[] args) {
        File file=new File ("D:\\IDEA\\JAVA_places\\泛型+File1\\src\\aaa") ;
        if(file.exists ()){
        selectFile (file);
        System.out.println("-------");
        selectFile02 (file);
        }else{
            System.out.println ("文件不存在");
        }
    }
    private static void selectFile(File file01) {
        File[] files=file01.listFiles (new FileFilterImpl ());
        for (File file : files) {
            if(file.isDirectory ()){
                selectFile (file);
            }else {
                System.out.println (file);
            }
        }
    }
    private static void selectFile02(File file01) {
        // 1 .FileFilter判断接口
        //匿名内部类的使用
        /*File[] files=file01.listFiles (new FileFilter () {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory () || pathname.getName ().toLowerCase ().endsWith (".java");
            }
        });*/
        File[] files=file01.listFiles (fileName ->fileName.isDirectory () || fileName.getName ().toLowerCase ().endsWith (".java"));

        //2 FilenameFilter
        /*File[] files=file01.listFiles (new FilenameFilter () {
            @Override
            public boolean accept(File dir, String name) {
                return new File (dir,name).isDirectory () || name.toLowerCase ().endsWith (".java");
            }
        }
        });*/

        //File[] files=file01.listFiles ((dir, name) -> new File (dir,name).isDirectory () || name.toLowerCase ().endsWith (".java"));
        for (File file : files) {
            if(file.isDirectory ()){
                selectFile (file);
            }else {
                System.out.println (file);
            }
        }
    }
}
