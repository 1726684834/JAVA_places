package class01Java基础;/** * @author ZhangJunqi * @Date 2021/10/7 -9:29 *///定义Object可以存储各种类型对象public class Demo02泛型 {    private Object a;    public Demo02泛型(Object a) {        this.a = a;    }    public void set (Object a){        this.a=a;    };    public Object getA() {        return a;    }    public static void main(String[] args) {        Demo02泛型 demo02 = new Demo02泛型 (new Genericity ());        Genericity genericity = (Genericity) demo02.getA ();        demo02.set (" No class01Java基础.Genericity");        String s = demo02.getA ().toString ();        demo02.set (1);        Integer integer = (Integer) demo02.getA ();    }}