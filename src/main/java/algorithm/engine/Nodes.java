package algorithm.engine;

import java.math.BigDecimal;



public class Nodes{
	
	private Nodes() {}
	
	public static Node createDefaultNode(String nodeName) {
		return new NodeImpl(nodeName,false);
	}
	
	public static Node createSymbolNode(String nodeName) {
		return new NodeImpl(nodeName,true);
	}

}


class NodeImpl implements Node {
	
	private boolean isSymbolNode;
	
	private String nodeName;
	
	private BigDecimal nodeValue;
	
	public NodeImpl(String nodeName,boolean isSymbolNode) {
		this.nodeName=nodeName;
		this.isSymbolNode=isSymbolNode;
	}

	@Override
	public boolean isSymbolNode() {
		return isSymbolNode;
	}

	@Override
	public String getNodeName() {
		return this.nodeName;
	}
	
	@Override
	public BigDecimal getNodeValue() {
		return this.nodeValue;
	}

	@Override
	public void setNodeValue(BigDecimal nodeValue) {
		this.nodeValue=nodeValue;
		
	}

}