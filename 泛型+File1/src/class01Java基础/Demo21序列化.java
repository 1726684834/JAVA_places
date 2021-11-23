package class01Java基础;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangJunqi
 * @Date 2021/10/24 -15:55
 */
public class Demo21序列化 {
    /*
    java.io.ObjectOutputStream extends OutputStream
    ObjectOutputStream:对象的序列化流
    作用:把对象以流的方式写入到文件中保存

    构造方法:
        ObjectOutputStream(OutputStream out) 创建写入指定 OutputStream 的 ObjectOutputStream。
        参数:OutputStream out:字节输出流
    特有的成员方法:void writeObject(Object obj) 将指定的对象写入 ObjectOutputStream。

    java.io.ObjectInputStream extends InputStream
    ObjectInputStream:对象的反序列化流
    作用:把文件中保存的对象,以流的方式读取出来使用

    构造方法:
        ObjectInputStream(InputStream in) 创建从指定 InputStream 读取的 ObjectInputStream。
        参数:InputStream in:字节输入流
        特有的成员方法:Object readObject() 从 ObjectInputStream 读取对象。

     readObject方法声明抛出了ClassNotFoundException(class文件找不到异常)
     当不存在对象的class文件时抛出此异常
     反序列化的前提:
        1.类必须实现Serializable
        2.必须存在类对应的class文件
 */
    public static  List<BPerson> bPersonList=new ArrayList<BPerson> ();
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //序列化
        File file=new File ("泛型+File1\\src\\class01Java基础\\BPersion.txt");
        ObjectOutputStream objectOutputStream=new ObjectOutputStream (new FileOutputStream(file));//true
        List<BPerson> bPersons=new ArrayList<BPerson> ();
        bPersons.add (new BPerson ("loli","pink",8.0,16));
        bPersons.add (new BPerson ("ripe","technology",9.0,30));
        bPersons.add (new BPerson ("tall","pinkAndBhAndBreaSts",10.0,18));
        //bPersons.add (null);
        //也可以直接objectOutputStream添加这个list,但是不方便后续维护
        //objectOutputStream.writeObject (bPersons);
        bPersons.forEach (bPerson -> {
            try {
                objectOutputStream.writeObject (bPerson);
            } catch (IOException e) {
                e.printStackTrace ();
            }
        });
        objectOutputStream.close ();

        //反序列化
        ObjectInputStream objectInputStream=new ObjectInputStream (new FileInputStream (file));
        /**
         * 读取时报EOFException的解决方法：
         * 1.插入对象到文件时最后添加一个null
         * 2.try catch进行EOFException异常捕捉
         */

        /*BPerson o;
        while ((o=(BPerson)objectInputStream.readObject ())!=null){
            bPersonList.add (o);
        }*/
        try {
            while (true){
                bPersonList.add ((BPerson)objectInputStream.readObject ());
            }
        }catch (EOFException eofException){
            System.out.println (eofException);
        }
        bPersonList.forEach (System.out::println);
        objectInputStream.close ();

    }
}
