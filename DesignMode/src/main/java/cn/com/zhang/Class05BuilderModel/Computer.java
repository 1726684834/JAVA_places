package cn.com.zhang.Class05BuilderModel;

/**
 * @author ZhangJunqi
 * @Date 2021/12/4 -16:03
 */
public class Computer {
    private String cpu;
    private String ram;
    private String card;

    public Computer(String cpu, String ram, String card) {
        this.cpu = cpu;
        this.ram = ram;
        this.card = card;
    }

    public Computer() {

    }

    public String getCpu() {
        return cpu;
    }

    public Computer setCpu(String cpu) {
        this.cpu = cpu;
        return this;
    }

    public String getRam() {
        return ram;
    }

    public Computer setRam(String ram) {
        this.ram = ram;
        return this;
    }

    public String getCard() {
        return card;
    }

    public Computer setCard(String card) {
        this.card = card;
        return this;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", card='" + card + '\'' +
                '}';
    }
}
