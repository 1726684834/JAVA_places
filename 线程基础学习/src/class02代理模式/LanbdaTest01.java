package class02代理模式;

/**
 * @author ZhangJunqi
 * @Date 2021/10/28 -23:24
 */
public class LanbdaTest01 {
    public static void main(String[] args) {
        //lambda除非有好基础不建议直接写，应该先写简单的然后慢慢的优化，这样最好 写一个简单的还行，带点难度的不就不好写了。
        Play play=(a)->{
            System.out.println (a);
        };
        play.play ("ლ(′◉❥◉｀ლ)");
    }
}
interface Play{
    public void play(String a);
}
