package class01Java基础;

/**
 * @author ZhangJunqi
 * @Date 2021/10/7 -9:20 泛型
 */
//只能持有单个对象的类
public class Demo01泛型 {
    private Genericity g;

    public Demo01泛型(Genericity g) {
        this.g = g;
    }

    public Genericity getG() {
        return g;
    }
}
class Genericity {
    public Genericity() {
        System.out.println("Genericity类型");
    }
}