package cn.com.zhang.reflect;

/**
 * @author ZhangJunqi
 * @Date 2021/11/28 -21:39
 */
public class Demo04Loader {
    public static void main(String[] args) throws ClassNotFoundException {
        //系统类加载器
        ClassLoader classLoader=ClassLoader.getSystemClassLoader ();
        System.out.println(classLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2
        //扩展类加载器
        ClassLoader parent=classLoader.getParent ();
        System.out.println(parent);//sun.misc.Launcher$ExtClassLoader@4554617c
        //根加载器
        ClassLoader grandParent=parent.getParent ();
        System.out.println (grandParent);//null
        //当前类加载器
        ClassLoader classLoaderNow=Class.forName ("cn.com.zhang.reflect.Demo04Loader").getClassLoader ();
        System.out.println (classLoaderNow);//sun.misc.Launcher$AppClassLoader@18b4aac2

        //JDK内置类是谁加载的
        ClassLoader classLoaderJDK=Class.forName ("java.lang.Object").getClassLoader ();
        System.out.println (classLoaderJDK);

        //获得系统类加载器可以加载的路径
        System.out.println (System.getProperty ("java.class.path"));//null

        /*
        C:\Program Files\Java\jdk1.8.0_101\jre\lib\charsets.jar;
        C:\Program Files\Java\jdk1.8.0_101\jre\lib\deploy.jar;
        C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\access-bridge-64.jar;
        C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\cldrdata.jar;
        C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\dnsns.jar;
        C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\jaccess.jar;
        C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\jfxrt.jar;
        C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\localedata.jar;
        C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\nashorn.jar;
        C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\sunec.jar;
        C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\sunjce_provider.jar;C
        :\Program Files\Java\jdk1.8.0_101\jre\lib\ext\sunmscapi.jar;
        C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\sunpkcs11.jar;
        C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext\zipfs.jar;
        C:\Program Files\Java\jdk1.8.0_101\jre\lib\javaws.jar;
        C:\Program Files\Java\jdk1.8.0_101\jre\lib\jce.jar;
        C:\Program Files\Java\jdk1.8.0_101\jre\lib\jfr.jar;
        C:\Program Files\Java\jdk1.8.0_101\jre\lib\jfxswt.jar;
        C:\Program Files\Java\jdk1.8.0_101\jre\lib\jsse.jar;
        C:\Program Files\Java\jdk1.8.0_101\jre\lib\management-agent.jar;
        C:\Program Files\Java\jdk1.8.0_101\jre\lib\plugin.jar;
        C:\Program Files\Java\jdk1.8.0_101\jre\lib\resources.jar;
        C:\Program Files\Java\jdk1.8.0_101\jre\lib\rt.jar;
        D:\IDEA\JAVA_places\out\production\AnnotationAndReflect;E:\IntelliJ IDEA\lib\idea_rt.jar
         */


    }
}
