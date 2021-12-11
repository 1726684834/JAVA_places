package cn.com.zhang.Class01Singleton;

import java.lang.reflect.Constructor;

/**
 * @author ZhangJunqi
 * @Date 2021/12/1 -22:48
 */
class Singleton01{
    private Singleton01() {
        System.out.println("这是一个单例类");
    }
    public static enum Demo02SingletonEnum {
        INSTANCE;
        private  Singleton01 instance;
        Demo02SingletonEnum(){
            instance=new Singleton01 ();
        }
        public Singleton01 getInstance(){

            return instance;
        }

        public static void main(String[] args) throws Exception{
            //Singleton01 singleton01=Demo02SingletonEnum.INSTANCE.getInstance ();
            Demo02SingletonEnum instance=Demo02SingletonEnum.INSTANCE;
            Constructor<Demo02SingletonEnum> constructor=Demo02SingletonEnum.class.getDeclaredConstructor (String.class,int.class);
            constructor.setAccessible (true);
            Demo02SingletonEnum instance02=constructor.newInstance ();
            System.out.println(instance);
            System.out.println(instance02);//Cannot reflectively create enum objects
        }
    }

}