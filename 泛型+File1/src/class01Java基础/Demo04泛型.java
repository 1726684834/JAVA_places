package class01Java基础;

/**
 * @author ZhangJunqi
 * @Date 2021/10/7 -19:46
 */
class Demo04<A,B> {
    public final A a;
    public final B b ;

    public Demo04(A a, B b) {
        this.a=a;
        this.b=b;
    }
    @Override
    public String toString() {
        return "class01Java基础.Demo04{" + "a=" + a + ", B=" + b + '}';
    }
}

class ThreeTuple<A,B,C> extends Demo04{
    public final C c;

    public ThreeTuple(A a, B b,C c) {
        super (a, b);
        this.c=c;
    }

    @Override
    public String toString() {
        return "Demo041{"+a+" "+b+" "+c+"}";
    }
}

class TupleTest{
    static Demo04<String,Integer> f(){

        return new Demo04<String ,Integer> ("张",23);
    }

    static ThreeTuple<String,Integer,Genericity> g(){
        return new ThreeTuple<String,Integer,Genericity> ("俊",24,new Genericity ());
    }

    public static void main(String[] args) {
        Demo04<String ,Integer> demo04 = f();
        System.out.println(demo04);
        ThreeTuple<String,Integer,Genericity> threeTuple=g();
        System.out.println(threeTuple);
    }

}