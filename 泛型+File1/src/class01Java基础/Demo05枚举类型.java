package class01Java基础;

/*
@author ZhangJunqi
@Date 2021/10/7 -10:25
    枚举类型像是一个规范，例如我只想要NORMAL, REVERSE, UNKNOWN这三种类型不想有其他类型的存在，
    用if语句也可以解决但是未免有点太low，写一个枚举类型的类方法进行判断解决。
    这种变量能设置为已经定义的一组之中的一个，有效地防止用户提供无效值
*/
public class Demo05枚举类型 {
    public static void main(String[] args) {
        //枚举类型中的conpareTo方法比较的就是ordinal值
        Position[] positions=Position.values ();
        for (Position position : positions) {
            System.out.println ("position = " + position.name ()+" 序号："+position.ordinal ());
        }
        String s = "normal";
        s=Position.getPosition (s).toString ();
        System.out.println ("s = " + s);

        for (Day day : Day.values ()) {
            System.out.println ("day = " + day.name ()+" "+day.getDay ()+" "+day.ordinal ());
        }

    }
}
enum Position{
    NORMAL, REVERSE, UNKNOWN;
    public static Position getPosition(String pos) {
        if (pos == null) {
            return null;
        }
        pos = pos.toUpperCase();
        Position[] positions = Position.values();
        for (Position position : positions) {
            if (position.name().equals(pos)) {
                return position;
            }
        }
        return null;
    }
}
enum Day{
    MONDAY("星期一"),
    TUESDAY("星期二"),
    EDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期日");
    private String day;
    private Day(String day) {
        this.day=day;
    }

    public String getDay() {
        return day;
    }
}