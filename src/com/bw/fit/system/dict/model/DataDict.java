package com.bw.fit.system.dict.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import com.bw.fit.system.common.util.treeHandler.Children;
import com.bw.fit.system.common.util.treeHandler.DataDictChildren;
import com.bw.fit.system.common.model.BaseModel;

public class DataDict extends BaseModel   implements Serializable{

	private static final long serialVersionUID = 544598881L;

	@NotEmpty(message="请先选中记录")
	private String parent_id;
	private String dict_name;
	private String dict_value;
	private String dict_remark;
	private String num;
	private String can_add;
	private String can_edit;
	private String can_del;
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	public String getDict_name() {
		return dict_name;
	}
	public void setDict_name(String dict_name) {
		this.dict_name = dict_name;
	}
	public String getDict_value() {
		return dict_value;
	}
	public void setDict_value(String dict_value) {
		this.dict_value = dict_value;
	}
	public String getDict_remark() {
		return dict_remark;
	}
	public void setDict_remark(String dict_remark) {
		this.dict_remark = dict_remark;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getCan_add() {
		return can_add;
	}
	public void setCan_add(String can_add) {
		this.can_add = can_add;
	}
	public String getCan_edit() {
		return can_edit;
	}
	public void setCan_edit(String can_edit) {
		this.can_edit = can_edit;
	}
	public String getCan_del() {
		return can_del;
	}
	public void setCan_del(String can_del) {
		this.can_del = can_del;
	}
	
	
	
	
	

	/**
	 * 孩子节点列表
	 */
	private DataDictChildren children = new DataDictChildren();

	// 先序遍历，拼接JSON字符串
	public String toString() {
		String result = "{" + "id : '" + getId() + "'" + ", dict_value : '" + this.getDict_value() + "'"
				+ ", dict_remark : '" + this.getDict_remark() + "'"
				+ ", can_add : '" + this.getCan_add() + "'"
				+ ", can_edit : '" + this.getCan_edit() + "'"
				+ ", can_del	 : '" + this.getCan_del() + "'"				
				+ ", num	 : '" + this.getNum() + "'"							
				+ ", parent_id	 : '" + this.getParent_id() + "'"
				+ ", dict_name :'"+this.getDict_name()+"'";
		
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
	public void addChild(DataDict node) {
		this.children.addChild(node);
	}

}
