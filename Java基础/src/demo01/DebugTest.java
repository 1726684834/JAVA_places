package demo01;

import java.util.HashMap;

/**
 * @author ZhangJunqi
 * @Date 2021/9/22 -21:30
 */
public class DebugTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println ("i = " + i);
        }
        HashMap<String,Object > stuMap=new HashMap<String ,Object> ();
        stuMap.put ("name","zhangsan");
        stuMap.put ("age",12);
        stuMap.put ("Manger","computer");
        stuMap.put ("School","default");
        System.out.println();
        int age= (int) stuMap.get ("age");
        //soutv
        System.out.println ("age = " + age);

        stuMap.replace ("School","lzjt");
        String stuSchool=stuMap.get ("School").toString ();
        System.out.println ("stuSchool = " + stuSchool);

    }
}
