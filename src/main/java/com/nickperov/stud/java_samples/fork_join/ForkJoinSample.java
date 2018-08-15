package com.nickperov.stud.java_samples.fork_join;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinSample {
	
	private static Node mainRootNode = null;
	
	//private static final Random treeRandom = new Random();
	
	private static final int maxLevelNumber = 5;
	private static final int maxChildNumber = 3;
	
	public static void main(String[] args) {
		
		Node root = getRootNode();
		printTree(root);
		long summ;
		long timeStart, timeFinish;
		
		System.out.println("=======================TEST 1=====================");
		summ  = new ForkJoinPool().invoke(new ValueSumCounter1(root));
		System.out.println("Summ: " + summ);
		
		System.out.println("=======================TEST 2=====================");
	    summ  = new ForkJoinPool().invoke(new ValueSumCounter2(root));
	    System.out.println("Summ: " + summ);
	}
	
	private static void createTestTree(Node rootNode, int levels, int l) {
		
		rootNode.setValue(new Random().nextInt(10000));
		rootNode.setLevel(l);
		
		if (l++ <= levels) {
			int children = new Random().nextInt(maxChildNumber - 1) + 1;
			
			List<Node> childList = new ArrayList<>(children);
			rootNode.setChildren(childList);
			
			int ch = 1;
			while (ch++ <= children) {
				Node element = new TreeElement();
				childList.add(element);
				createTestTree(element, levels, l);
			}
		} else {
			rootNode.setChildren(Collections.<Node> emptyList());
		}
	}
	
	private static Node getRootNode() {
		if (mainRootNode == null) {
			mainRootNode = new TreeElement();			
			int levels = new Random().nextInt(maxLevelNumber - 1) + 1;
			createTestTree(mainRootNode, levels, 1);
		}
		
		return mainRootNode;
	}
	
	private static void printTree(Node rootNode) {
		
		System.out.println(rootNode.getValue() + " :: " + rootNode.getLevel());
		if (rootNode.getChildren() != null)
			for (Node ch : rootNode.getChildren())
				printTree(ch);
		
	}
}

class TreeElement implements Node {
	
	private long level;
	private long value;
	private List<Node> children;
	
	@Override
	public void setChildren(List<Node> children) {
		this.children = children;
	}

	@Override
	public List<Node> getChildren() {
		return children;
	}

	@Override
	public long getValue() {
		return value;
	}

	@Override
	public void setValue(long value) {
		this.value = value;
	}

	@Override
	public void setLevel(long level) {
		this.level = level;
	}
	
	@Override
	public long getLevel() {
		return level;
	}
}
