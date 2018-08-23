package com.bw.fit.system.dict.model;

import com.bw.fit.system.common.model.BaseModel;
import com.bw.fit.system.dict.model.treeHandler.DataDictChildren;

public class Dict extends BaseModel {

	private String dictName;
	private String parentId;
	private String dictValue;
	private String canAdd;
	private String canEdit;
	private String canDel;
	private String DictRemark;
	public String getDictName() {
		return dictName;
	}
	public void setDictName(String dictName) {
		this.dictName = dictName;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getDictValue() {
		return dictValue;
	}
	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}
	public String getCanAdd() {
		return canAdd;
	}
	public void setCanAdd(String canAdd) {
		this.canAdd = canAdd;
	}
	public String getCanEdit() {
		return canEdit;
	}
	public void setCanEdit(String canEdit) {
		this.canEdit = canEdit;
	}
	public String getCanDel() {
		return canDel;
	}
	public void setCanDel(String canDel) {
		this.canDel = canDel;
	}
	public String getDictRemark() {
		return DictRemark;
	}
	public void setDictRemark(String dictRemark) {
		DictRemark = dictRemark;
	}
	
	
	

	

	/**
	 * 孩子节点列表
	 */
	private DataDictChildren children = new DataDictChildren();

	// 先序遍历，拼接JSON字符串
	public String toString() {
		String result = "{" + "id : '" + getId() + "'" + ", dictValue : '" + this.getDictValue() + "'"
				+ ", dictRemark : '" + this.getDictRemark() + "'"
				+ ", canAdd : '" + this.getCanAdd() + "'"
				+ ", canEdit : '" + this.getCanEdit() + "'"
				+ ", canDel	 : '" + this.getCanDel() + "'"				
				+ ", num	 : '" + this.getSortNumber() + "'"						
				+ ", parentId	 : '" + this.getParentId() + "'"
				+ ", dictName :'"+this.getDictName()+"'";
		
		if (children != null && children.getSize() != 0) {
			result += ", children : " + children.toString();
		} else {
			result += ", leaf : true";
		}

		return result + "}";
	}

	// 兄弟节点横向排序
	public void sortChildren() {
		if (children != null && children.getSize() != 0) {
			children.sortChildren();
		}
	}

	// 添加孩子节点
	public void addChild(Dict node) {
		this.children.addChild(node);
	}
	
}
