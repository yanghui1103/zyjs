package com.bw.fit.system.common.util.treeHandler;

import java.util.Comparator;

import com.bw.fit.system.common.util.Node;

public class NodeIDComparator implements Comparator {
	// 按照节点编号比较
	public int compare(Object o1, Object o2) { 
		int j1 = Integer.parseInt(((Node) o1).num);
		int j2 = Integer.parseInt(((Node) o2).num);
		return (j1 < j2 ? -1 : (j1 == j2 ? 0 : 1));
	}

}
