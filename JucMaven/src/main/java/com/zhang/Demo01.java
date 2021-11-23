package com.zhang;

import java.util.UUID;

/**
 * @author ZhangJunqi
 * @Date 2021/11/3 -23:49
 */
public class Demo01 {
    public static void main(String[] args) {
        //获取CPU核数
        System.out.println (Runtime.getRuntime ().availableProcessors ());
        System.out.println (UUID.randomUUID ().toString ());



    }
}
