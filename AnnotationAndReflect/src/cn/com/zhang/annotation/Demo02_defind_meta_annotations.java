package cn.com.zhang.annotation;

import java.lang.annotation.*;

/**
 * @author ZhangJunqi
 * @Date 2021/11/27 -20:29
 */
@MyAnnotations
@SuppressWarnings ("all")
class Demo02_defind_meta_annotations {
    @MyAnnotations(name = "method")
    public static void test(){}
}
/*
元注解的作用就是负责注解其它注解)，Java定义了4个标准的meta-annotation类型,他们被用来提供对其他annotation类型作说明。
@Target( ElementType[] value ) :用于描述注解的使用范围(即:被描述的注解可以用在什么地方)
@Retention( RetentionPolicy value ):表示需要在什么级别保存该注释信息﹐用于描述注解的生命周期
(SOURCE<CLASS< RUNTIME)
@Document  :说明该注解将被包含在javadoc中
@Inherited  :说明子类可以继承父类中的该注解
 */
@Target ({ElementType.TYPE,ElementType.METHOD,})
@Retention (RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface MyAnnotations{
    //注解参数： 参数类型+参数名+ ()
    String name() default "";
    int age() default -1;//默认值-1 表示不存咋
    String[] school() default {"",""};
}