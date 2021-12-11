package cn.com.zhang.Class04AbstractFactory;

/**
 * @author ZhangJunqi
 * @Date 2021/12/4 -10:46
 */
public class Test {
    public static void main(String[] args) {
        PCFactory logicechFactory=new LogicechFactory();
        Mouse logicMouse=logicechFactory.getMouse ();
        System.out.println(logicMouse.getMouseType ());

        Keyboard logicechKeyboard=logicechFactory.getKeyboard ();
        System.out.println(logicechKeyboard.getKeyboardType ());

        /*
        在添加新的产品对象时，难以扩展抽象工厂来生产新种类的产品，这是因为在抽象工厂角色中规定了所有可能被创建的产品集合，
        要支持新种类的产品就意味着要对该接口进行扩展，而这将涉及到对抽 象工厂角色及其所有实现类的修改，显然会带来较大的不便。
        总结：增加新的工厂和产品族容易，增加新的产品等级结构比较麻烦。所有没有完全符合开闭原则的 解决方案，要根据实际情况倾斜。
         */

    }
}
