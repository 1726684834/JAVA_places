package cn.com.zhang.reflect;

/**
 * @author ZhangJunqi
 * @Date 2021/11/28 -14:22
 */
@SuppressWarnings ("all")
public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class class01=Class.forName ("cn.com.zhang.reflect.Student");
        Class class02=Class.forName ("cn.com.zhang.reflect.Student");
        Class class03=Student.class;
        Class class04= new Student ().getClass ();
        System.out.println(class01+" "+(class01.hashCode()==class02.hashCode ()  )+" "+ (
                                        class03.hashCode()==class04.hashCode ()  ));
        Class intClass=Integer.TYPE;
        System.out.println(intClass);//int

        Class class05=class01.getSuperclass ();
        System.out.println(class05);//class cn.com.zhang.reflect.Person
    }
}
class Person{
    private String name;
    private String code;
    private int age;

}
class Student extends Person{
    private String stuName;
    private String stuCode;
    private int stuAge;

    public Student() {
    }

    public Student(String stuName, String stuCode, int stuAge) {
        this.stuName = stuName;
        this.stuCode = stuCode;
        this.stuAge = stuAge;
    }

    public String getStuName() {
        return stuName;
    }

    public Student setStuName(String stuName) {
        this.stuName = stuName;
        return this;
    }

    public String getStuCode() {
        return stuCode;
    }

    public Student setStuCode(String stuCode) {
        this.stuCode = stuCode;
        return this;
    }

    public int getStuAge() {
        return stuAge;
    }

    public Student setStuAge(int stuAge) {
        this.stuAge = stuAge;
        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuName='" + stuName + '\'' +
                ", stuCode='" + stuCode + '\'' +
                ", stuAge=" + stuAge +
                '}';
    }
}
