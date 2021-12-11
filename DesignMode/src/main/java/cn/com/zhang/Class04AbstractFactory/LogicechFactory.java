package cn.com.zhang.Class04AbstractFactory;

/**
 * @author ZhangJunqi
 * @Date 2021/12/4 -10:47
 */
public class LogicechFactory implements PCFactory{
    public Mouse getMouse() {
        return new LogitechMouse ();
    }

    public Keyboard getKeyboard() {
        return new LogicechKeyboard ();
    }
}
