package demo01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangJunqi
 * @Date 2021/9/20 -16:38
 */
/*      fori iter

        ifn inn
        syso  soutv
*/
public class mode01 {
    //快捷模板
    //prsf :private static final
    // psf是public
    //psfi  int类型 psfs String类型
    private static final  int  PRSF=1;
    public static final int PSF=1;
    //st=static
    //main
    public static <Char> void main(String[] args) {
        //st=String
        String str1="I love you";
        String str2=new String ("Sorry");
        List<String> list1=new ArrayList<String>();
        list1.add ("I " +
                "do not " +
                "like " +
                "you");
        list1.add ("But " +
                "Always " +
                "someone " +
                "like " +
                "you");
        //fori  记住这一个就OK
        for (int i = 0; i < 5; i++) {

        }
        //itar  ritar逆向
        for (int y = 0; y < str1.length(); y++) {
            char c = str1.charAt (y);
            System.out.print (c+" ");
        }
        System.out.println ();
        //iter 或者list1.for
        for (String arg : list1) {
            System.out.println (arg+" ");
        }

        //itli  list1.fori   forr是逆向
        for (int i = 0; i < list1.size (); i++) {
            String  o =  list1.get (i);
            
        }

        System.out.println ();
        //ifn  inn是 !=null   ||  .null  .inn
        if (list1 == null) {

        }

        //soutv
        String str3="I";
        System.out.println ("str3 = " + str3);

    }
}
