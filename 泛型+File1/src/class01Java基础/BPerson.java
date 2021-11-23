package class01Java基础;

import java.io.Serializable;

/**
 * @author ZhangJunqi
 * @Date 2021/10/24 -15:59
 */
/*
    序列化和反序列化的时候,会抛出NotSerializableException没有序列化异常
    类通过实现 java.io.Serializable 接口以启用其序列化功能。未实现此接口的类将无法使其任何状态序列化或反序列化。
    Serializable接口也叫标记型接口
        要进行序列化和反序列化的类必须实现Serializable接口,就会给类添加一个标记
        当我们进行序列化和反序列化的时候,就会检测类上是否有这个标记
            有:就可以序列化和反序列化
            没有:就会抛出 NotSerializableException异常

    static关键字:静态关键字
        静态优先于非静态加载到内存中(静态优先于对象进入到内存中)
        被static修饰的成员变量不能被序列化的,序列化的都是对象

    transient关键字:瞬态关键字
        被transient修饰成员变量,不能被序列化
 */
public class BPerson implements Serializable {
    //定义序列号
    private static final long serialVersionUID=1L;
    private String type;
    private String stature;
    public double grade;
    private transient int age;


    public BPerson(String type, String stature, double grade, int age) {
        this.type = type;
        this.stature = stature;
        this.grade = grade;
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    public BPerson setAge(int age) {
        this.age = age;
        return this;
    }

    public String getType() {
        return type;
    }

    public BPerson setType(String type) {
        this.type = type;
        return this;
    }

    public String getStature() {
        return stature;
    }

    public BPerson setStature(String stature) {
        this.stature = stature;
        return this;
    }

    public double getGrade() {
        return grade;
    }

    public BPerson setGrade(double grade) {
        this.grade = grade;
        return this;
    }

    @Override
    public String toString() {
        return "BPerson{" +
                "type='" + type + '\'' +
                ", stature='" + stature + '\'' +
                ", grade=" + grade +
                ", age=" + age +
                '}';
    }
}
