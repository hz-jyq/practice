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


    static int getValue(String string) {
        if ("+".equals(string) || "-".equals(string)) {
            return 1;
        } else if (("/".equals(string) || "*".equals(string))) {
            return 2;
        }
        return 0;
    }

    static int comparator(String o1, String o2) {
        return getValue(o1) - getValue(o2);
    }

    ;


    public static void main(String[] args) {
        String str1 = "3*(7+7-6)-6";
        List linkedList = new LinkedList();
        Deque<String> queue = new LinkedList();
        for (char c : str1.toCharArray()) {
            String ch = String.valueOf(c);
            if (Arrays.asList(SYMBOL).contains(ch)) {
                if (c == '(' || queue == null) {
                    queue.push(ch);
                    continue;
                }
                if(c == ')'){
                   String pop = queue.pop();
                   while (!pop.equals("(")) {
                        linkedList.add(pop);
                        pop = queue.pop();
                   }
                   continue;
                }
                while (queue.peek() != null && comparator(ch, queue.peek()) < 1) {
                    linkedList.add(queue.poll());
                }
                queue.push(ch);
                continue;
            } else {
                linkedList.add(c);
                continue;
            }
        }
        for (String string : queue) {
            linkedList.add(string);
        }
        System.out.println(linkedList);
    }


}
