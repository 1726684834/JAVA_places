package demo01;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author ZhangJunqi
 * @Date 2021/9/15 -11:22
 */
/*
    call hierarchy: ctrl alt H
    type hierarchy:F4
    ctrl +d：刪除当前行
    多行注释	ctrl + shift + /
    alt+enter：生成返回值
    ctrl+alt+/ ：提示方法参数类型
    ctrl+o ：查看类结构
    重构：修改变量名与方法名(rename)：alt+shift+r
    生成构造器/get/set/toString 	    alt +shift + s

    alt + enter
    选中数行，整体往后移动			tab
	选中数行，整体往前移动			shift + tab
	局部变量抽取为成员变量(introduce field)			alt+shift+f
	查看类的继承结构图(Show UML Diagram)    	ctrl + shift + u
	快速搜索类中的错误(next highlighted error)			ctrl + shift + q
	选择要粘贴的内容(Show in Explorer)				ctrl+shift + V
*/
public class class01Son extends class01{
    public class01Son(){
        System.out.println("Son");

    }

    public static void main(String arg[]){
        class01Son son=new class01Son();
        son.setAge (22);
        ArrayList<Object> list = getObjects ();

        Date date = new Date();
        System.out.println (date);
        System.out.println (list);
        System.out.println (son.toString ());

    }

    public static @NotNull ArrayList<Object> getObjects() {
        ArrayList<Object> list = new ArrayList<Object>();
        list.add ("object");
        return list;
    }

}
