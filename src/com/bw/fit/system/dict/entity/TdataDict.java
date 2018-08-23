package com.bw.fit.system.dict.entity;

import com.bw.fit.system.common.entity.BaseEntity;

public class TdataDict extends BaseEntity {

	private String parent_id;
	private String dict_name;
	private String dict_value;
	private String dict_remark;
	private String num;  //序号
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
	


}
