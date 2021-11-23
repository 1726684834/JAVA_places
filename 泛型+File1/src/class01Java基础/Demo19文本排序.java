package class01Java基础;

import java.io.*;
import java.util.HashMap;

/**
 * @author ZhangJunqi
 * @Date 2021/10/23 -15:12
 */
public class Demo19文本排序 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader (new FileReader (new File ("泛型+File1\\src\\class01Java基础\\list.txt")));
        BufferedWriter bufferedWriter=new BufferedWriter (new FileWriter ("泛型+File1\\src\\class01Java基础\\出师表.txt"));
        HashMap<String,String> hashMap=new HashMap<String, String> ();
        String line;
        while ((line=bufferedReader.readLine ())!=null){
            String[] arr=line.split ("\\.");//对读取到的文本进行切割,获取行中的序号和文本内容
            hashMap.put (arr[0],arr[1]);//把切割好的序号和文本的内容存储到HashMap集合中(key序号是有序的,会自动排序1,2,3,4..)
        };
        //遍历并写入到新txt中
        hashMap.entrySet ().stream ().forEach ((entry)->{
            try {
                bufferedWriter.write (entry.getKey ()+"."+entry.getValue ());
                bufferedWriter.newLine ();
            } catch (IOException e) {
                e.printStackTrace ();
            }
        });
        bufferedReader.close ();
        bufferedWriter.close ();
    }
}
