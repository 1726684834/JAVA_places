package com.zhang.class10Single;

/**
 * @author ZhangJunqi
 * @Date 2021/11/17 -22:02
 */
public class Demo02Singleton {
    //在类的字节码文件第一次加载到内存时创建对象
    private static Demo02Singleton instance=new Demo02Singleton ();

    private Demo02Singleton() {
    }
    private  static Demo02Singleton getInstance(){
        return instance;
    }
}
