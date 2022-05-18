package algorithm;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author jyq
 * @Date 2022/4/29 16:18
 */
public class SerializeUtil {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        String str = "100000000000000000";
        for (int i = 0; i < 200000; i++) {
            list.add(str + i);
        }
        // byte[] bytes = serialize(content);
         //System.out.print(bytes);
         //System.out.println(unserialize(bytes));
    }

    public static byte[] serialize(Object object){

        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            //序列化
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static Object unserialize(byte[] bytes) {
        ByteArrayInputStream bais = null;
        try {
            //反序列化
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
