package algorithm.engine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import cn.hutool.core.util.StrUtil;

public class FormulaUtils {
	

	private static final String SYMBOL = "+-*/()"; // 运算符
	
	private static final String[] PRIORITY = { "+-", "*/", "()" }; // 运算符优先级
	
	/**
	 * 运算符比较器
	 */
	private static Comparator<String> comp = (String s1, String s2) -> {
		int n1 = 0;
		int n2 = 0;
		for (int i = 0; i < PRIORITY.length; i++) {
			if (PRIORITY[i].indexOf(s1) >= 0) {
				n1 = i;
			}
			if (PRIORITY[i].indexOf(s2) >= 0) {
				n2 = i;
			}
		}
		return (n1 - n2);
	};
		
	private FormulaUtils() {}
	
	/**
     * 分析算式
     * @param exp
     * @return
     * @throws Exception
     */
    public static List<Node> analyze(String exp){
        if (StrUtil.isBlank(exp)) {
            throw new RuntimeException("illegal parameter.");
        }
        exp = exp.replaceAll("\\s*", ""); //去掉所有的空格（为了方便中间存在空格算合法）

        List<Node> list = new ArrayList<>();
        Deque<String> sym = new LinkedList<>();

        StringBuilder buf = new StringBuilder();
        for (char c : exp.toCharArray()) {
        	//如果是运算符
            if (SYMBOL.indexOf(c) >= 0) {
            	 //如果有操作数
                if (buf.length() > 0) {
                    String v = buf.toString();
                    list.add(Nodes.createDefaultNode(v));
                    buf.delete(0, buf.length());
                }

                if (c == '(') {
                    sym.push(String.valueOf(c));
                } else if (c == ')') {
                    String last = "";
                    while (!sym.isEmpty()) {
                        last = sym.pop();
                        if (last.equals("(")) {
                            break;
                        } else {
                            list.add(Nodes.createSymbolNode(last));
                        }
                    }
                    if (!"(".equals(last)) {
                        throw new RuntimeException("illigal express.");
                    }
                } else if (!sym.isEmpty()) {
                    String s = String.valueOf(c);
                    String last = sym.peek();
                    if (last.equals("(") || comp.compare(s, last) > 0) {
                        sym.push(s);
                    } else {
                        last = sym.pop();
                        list.add(Nodes.createSymbolNode(last));
                        sym.push(s);
                    }
                } else {
                    sym.push(String.valueOf(c));
                }
            } else {
            	//不是运算符则当作操作数（因为已经去除所有空格，这里不再需要判断空格）
                buf.append(c);
            }
        }

        if (buf.length() > 0) {
            list.add(Nodes.createDefaultNode(buf.toString()));
        }

        while (!sym.isEmpty()) {
            String last = sym.pop();
            if ("()".indexOf(last) >= 0) {
                throw   new RuntimeException ("illigal express.");
            }
            list.add(Nodes.createSymbolNode(last));
        }
        
        return list;
    }
 
    
    /**
           * 计算公式结果
     * @param nodeList
     * @return
     */
    public static BigDecimal caculateFormula(List<Node> nodeList) {
    	Deque<BigDecimal> val = new LinkedList<>();
    	BigDecimal result = BigDecimal.ZERO;
        while (!nodeList.isEmpty()) {
        	Node node = nodeList.remove(0);
            String s = node.getNodeName();
            if (SYMBOL.indexOf(s) >= 0) {
            	BigDecimal d1 = val.pop();
            	BigDecimal d2 = val.pop();
                if ("+".equals(s)) {
                    result = d2.add(d1);
                } else if ("-".equals(s)) {
                    result = d2.subtract(d1);
                } else if ("*".equals(s)) {
                    result = d2.multiply(d1).setScale(2,BigDecimal.ROUND_HALF_UP);
                } else if ("/".equals(s)) {
                    result = d2.divide(d1,2, BigDecimal.ROUND_HALF_UP);
                } else {
                    throw new RuntimeException("illigal symbol("+s+").");
                }
                val.push(result);
            } else {
                val.push(node.getNodeValue());
            }
        }
        return  val.getFirst() == null ? result : val.getFirst();
    }




}
