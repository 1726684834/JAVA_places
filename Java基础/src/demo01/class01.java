package demo01;

/**
 * @author ZhangJunqi
 * @Date 2021/9/13 -22:34
 */
public class class01 {
    private static String stuName;
    private static String stuCode;
    private int age;

    public static void run(){
        System.out.println("father");
    }

    public static String getStuName() {
        return stuName;
    }

    public static void setStuName(String stuName) {
        class01.stuName = stuName;
    }

    public static String getStuCode() {
        return stuCode;
    }

    public static void setStuCode(String stuCode) {
        class01.stuCode = stuCode;
    }

    public int getAge() {
        return age;
    }

    public class01 setAge(int age) {
        this.age = age;
        return this;
    }
}
