package class01Java基础;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ZhangJunqi
 * @Date 2021/10/12 -22:57
 */
public class Lambda表达式 {
    public static void main(String[] args) {
        List<String> list01= Arrays.asList (new String[]{"a", "b", "c", "d"});
        list01.forEach (s -> {
            if("b".equals (s)){
                System.out.println(true);
            }
        });
        List<Integer> list02=new ArrayList<Integer> (){{
            for (int i = 0; i < 10; i++) {
                add (i);
            }
        }};
       //遍历输出list的方法
        /*List<Integer> list03=new ArrayList<Integer> (){{
            for (int i = 0; i < list02.size (); i++) {
                int a =  list02.get (i);
                if(a%2==0){
                    add (a);
                }
            }
        }};*/
        List<Integer>list03=list02.stream ()
                .filter (sum -> sum%2==0)
                .filter (sum -> sum%4==0).collect(Collectors.toList());
        list03.forEach (System.out::println);
    }
}
