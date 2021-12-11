package cn.com.zhang.Class05BuilderModel;

/**
 * @author ZhangJunqi
 * @Date 2021/12/4 -16:09
 */
public class ComputerBuilder implements Builder {
    private Computer computer=new Computer ();
    public void setCpu() {
        computer.setCpu ("cpu");
        System.out.println("组装cpu");
    }

    public void setRam() {
        computer.setRam ("ram");
        System.out.println("组装内存");
    }

    public void setCard() {
        computer.setCard ("card");
        System.out.println("组装显卡");
    }
    public Computer setComputer(){
        return computer;
    }
}
