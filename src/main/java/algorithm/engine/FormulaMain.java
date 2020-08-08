package algorithm.engine;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.apache.commons.lang3.ArrayUtils;

/**
 * @Author jyq
 * @Date 2020/8/8 16:01
 */
public class FormulaMain {

    static String[] SYMBOL = new String[]{"+","-","*","/"};

    static String[]  PRIORITY = new String[]{"+-","*/"};


    private static List<Node> analyze(String string){
        String  exp = string.replaceAll("\\s*", "");
        List<Node> nodes = new LinkedList<>();
        Queue<String> symbolNodes = new LinkedList();
        for(char c : exp.toCharArray()){
            String str = String.valueOf(c);
            if(ArrayUtils.contains(SYMBOL,str)){
                //比较大小
               // if()
                symbolNodes.add(str);
            }else{
                nodes.add(Nodes.createDefaultNode(str));
                while(!symbolNodes.isEmpty()){
                    nodes.add(Nodes.createSymbolNode(symbolNodes.poll()));
               }
            }
        }
        return  nodes;
    }

    public static void main(String[] args) {

        //a b +
        // a b c / + ;    a b  + c +
        List<Node>  nodes = analyze("a + b / c");
        System.out.println(nodes);
    }

}
