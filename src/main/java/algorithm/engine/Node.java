package algorithm.engine;

import java.math.BigDecimal;

public interface Node {
	
	/**
	  * 是否是运算符
	 * @return
	 */
	boolean isSymbolNode();  
	
	/**
	  * 获取节点名
	 * @return
	 */
	String getNodeName();
	
	/**
	  * 获取节值
	 * @return
	 */
	BigDecimal getNodeValue();
	
	/**
	  * 设置节点值
	 * @return
	 */
	void setNodeValue(BigDecimal nodeValue);

}
