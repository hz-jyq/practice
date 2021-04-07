package algorithm.engine;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Stream;

import cn.hutool.core.collection.CollectionUtil;
import org.apache.commons.lang3.ArrayUtils;

/**
 * @Author jyq
 * @Date 2020/8/8 16:01
 */
public class FormulaMain {

    static String[] SYMBOL = new String[]{"+", "-", "*", "/", "(", ")"};

    private static final String[] PRIORITY = {"+,-", "*,/"};

    static Comparator<String> com = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            int i = 0;
            int j = 0;
            for (String str : PRIORITY) {
                i = str.indexOf(o1);
                j = str.indexOf(o2);
            }
            return i - j;
        }
    };


    public static void main(String[] args) {
        String str1 = "3+7/7*6";
        List linkedList = new LinkedList();
        Deque<String> queue = new LinkedList();
        for (char c : str1.toCharArray()) {
            String ch = String.valueOf(c);
            if (Arrays.asList(SYMBOL).contains(ch)) {
                if (c == '(' || queue == null) {
                    queue.push(ch);
                    continue;
                }
                while (queue.peek() != null && com.compare(ch, queue.peek()) < 1) {
                    linkedList.add(queue.poll());
                }
                queue.push(ch);
                continue;
            } else {
                linkedList.add(c);
                continue;
            }
        }
        for(String string : queue){
            linkedList.add(string);
        }
        System.out.println(linkedList);
    }


}
