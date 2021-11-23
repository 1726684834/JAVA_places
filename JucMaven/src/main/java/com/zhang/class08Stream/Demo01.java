package com.zhang.class08Stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author ZhangJunqi
 * @Date 2021/11/11 -21:27
 */
public class Demo01 {
    public static void main(String[] args) {
        //stream流
        /*
            Stream<T> filter(Predicate<? super T> predicate);   筛选
            <R> Stream<R> map(Function<? super T, ? extends R> mapper);   处理传入的参数
            Stream<T> sorted(Comparator<? super T> comparator);   比较大小排序
            Stream<T> peek(Consumer<? super T> action); 在每个元素被消费时执行提供的操作从产生的流
            void forEach(Consumer<? super T> action);
            distinct()不重复的,不能比较对象
            Stream<T> limit(long maxSize); 限制输出个数
            Stream.reduce()合并流的元素并产生单个值   https://zhuanlan.zhihu.com/p/110151542
        */
        Student stu01=new Student (1,"a",21);
        Student stu02=new Student (2,"b",22);
        Student stu03=new Student (3,"c",23);
        Student stu04=new Student (4,"d",24);
        Student stu05=new Student (6,"e",25);
        Student stu06=stu05;//new Student (6,"e",25);
        List<Student> list = Arrays.asList (stu01,stu02,stu03,stu04,stu05,stu06);
                list.stream ()
                .filter (student -> student.id%2==0)
                .filter (student -> student.age>=23)
                .map (student -> student.setName (student.getName ().toUpperCase ()))
                .sorted ((stu1,stu2)->stu2.getName ().compareTo(stu1.getName ()))
                .distinct ().limit (2)
                .peek (student-> System.out.println (student.getName ()+"——Costumer"))
                .forEach (System.out::println);
    }
}