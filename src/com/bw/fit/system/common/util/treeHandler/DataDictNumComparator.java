package com.bw.fit.system.common.util.treeHandler;

import java.util.Comparator;

import com.bw.fit.system.dict.model.DataDict;


public class DataDictNumComparator implements Comparator {
	// 按照节点编号比较
	public int compare(Object o1, Object o2) { 
		int j1 = Integer.parseInt(((DataDict) o1).getNum());
		int j2 = Integer.parseInt(((DataDict) o2).getNum());
		return (j1 < j2 ? -1 : (j1 == j2 ? 0 : 1));
	}

}
