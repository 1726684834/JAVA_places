package cn.com.zhang.annotation;

import java.util.List;

/**
 * @author ZhangJunqi
 * @Date 2021/11/27 -16:57
 */

public class Demo01_Built_in_annotations extends Object{
    @Override
    public String toString() {
        return "Demo01_Built_in_annotations{}";
    }

    @SuppressWarnings ({"unchecked","all"})
    @Deprecated
    public static void  test(){
        List list;
        System.out.println("已过时的注解");
    }

    public static void main(String[] args) {
        test ();
    }
}
