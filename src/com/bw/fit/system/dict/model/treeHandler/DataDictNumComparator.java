package com.bw.fit.system.dict.model.treeHandler ;

import java.util.Comparator;

import com.bw.fit.system.dict.model.Dict;

public class DataDictNumComparator implements Comparator {
	// 按照节点编号比较
	public int compare(Object o1, Object o2) { 
		int j1 =  (((Dict) o1).getSortNumber());
		int j2 =  (((Dict) o2).getSortNumber());
		return (j1 < j2 ? -1 : (j1 == j2 ? 0 : 1));
	}

}
