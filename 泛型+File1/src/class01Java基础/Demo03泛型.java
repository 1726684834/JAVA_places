package class01Java基础;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZhangJunqi
 * @Date 2021/10/7 -13:37
 */
class Demo03<T> {
    private T t;

    public Demo03(T t) {
        this.t = t;
    }

    public Demo03() {
    }

    public T getT() {
        return t;
    }

    public Demo03<T> setT(T t) {
        this.t = t;
        return this;
    }

    public static void main(String[] args) {
        Demo03<Genericity> genericityDemo03 = new Demo03<Genericity> ();
        genericityDemo03.setT (new Genericity ());
        Genericity genericity = genericityDemo03.getT ();

        List<Integer> list = new ArrayList<Integer> () ;
        list.add (0);
        list.add (1);
        list.add (2);
        //查找：没有返回-1，有返回索引  用contains返回 boolean类型
        int i=list.indexOf (2);
        Boolean b=list.contains (2);
        System.out.println(i+" "+b);
        SecureRandom sr = null;
        try {
            sr = SecureRandom.getInstanceStrong(); // 获取高强度安全随机数生成器
        } catch (NoSuchAlgorithmException e) {
            sr = new SecureRandom(); // 获取普通的安全随机数生成器
        }
        byte[] buffer = new byte[16];
        sr.nextBytes(buffer); // 用安全随机数填充buffer
        System.out.println(Arrays.toString(buffer));

    }
}
