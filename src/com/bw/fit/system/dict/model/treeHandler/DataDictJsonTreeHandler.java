package com.bw.fit.system.dict.model.treeHandler;

import java.util.*;

import com.alibaba.fastjson.JSONArray; 
import com.bw.fit.system.dict.model.DataDict;
import com.bw.fit.system.dict.model.Dict;

public class DataDictJsonTreeHandler {
	public static void main(String[] args) {
		// 读取层次数据结果集列表
		List dataList = VirtualDataGenerator.getVirtualResult();
		getJSONTree(dataList);
	}

	public static DataDict getJSONTree(List dataList) {

		  // 节点列表（散列表，用于临时存储节点对象）
		  HashMap nodeList = new HashMap();
		  // 根节点
		  DataDict root = null;
		  // 根据结果集构造节点列表（存入散列表）
		  for (Iterator it = dataList.iterator(); it.hasNext();) {
		   Map dataRecord = (Map) it.next();
		   DataDict node = new DataDict();
		   node.setId((String)dataRecord.get("id")); 
		   node.setDict_value((String)dataRecord.get("dict_value")); 
		   node.setDict_name((String)dataRecord.get("dict_name"));
		   node.setNum((String)dataRecord.get("num"));
		   node.setCan_add((String)dataRecord.get("can_add"));
		   node.setCan_edit((String)dataRecord.get("can_edit"));
		   node.setCan_del((String)dataRecord.get("can_del"));
		   node.setDict_remark((String)dataRecord.get("dict_remark"));
		   node.setParent_id((String)dataRecord.get("parent_id"));
		   nodeList.put(node.getId(), node);
		  }
		  // 构造无序的多叉树
		  Set entrySet = nodeList.entrySet();
		  for (Iterator it = entrySet.iterator(); it.hasNext();) {
		   DataDict node = (DataDict) ((Map.Entry) it.next()).getValue();
		   if (node.getParent_id() == null || node.getParent_id().equals("")) {
		    root = node;
		   } else {
			   DataDict di = ((DataDict) nodeList.get(node.getParent_id()));
			   di.addChild(node);
		   }
		  }
		  // 对多叉树进行横向排序
		  root.sortChildren();
		  return root;
		 } 
}
  