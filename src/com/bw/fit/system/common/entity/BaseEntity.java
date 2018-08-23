package com.bw.fit.system.common.entity;
import static com.bw.fit.system.common.util.PubFun.*;

import java.util.Date;
import java.util.List;
/*****
 * 父实体类
 * @author yangh
 *
 */
public class BaseEntity {

	private String id ;
	private String keyWords="";	
	private String start_date="1900-01-01" ;
	private String end_date="2099-12-31" ;
	private String createTime ;
	private String versionTime ;
	private String creator;
	private String creatorName; 
	private String createOrgId;
	private String createOrgName;
	private String logId ;
	private String logContent;
	private String sql ;
	private String isdeleted;
	private String res ;
	private String msg ;
	private String returnInfo ;
	private String staff_id;
	private String action_name ;
	private String UUID ;
	private String status ;
	private int sortNumber;
	private String temp_str1;
	private String temp_str2;
	private String temp_str3;
	private String area ; // 场所
	/***
	 * 翻页使用
	 */
	private Integer page =1;
	private Integer rows =10;
	private Integer start_num;
	private Integer end_num;
	private String paginationEnable;
	private Integer rn ;
	private List<String> createOrgIds;
	
	
	
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public List<String> getCreateOrgIds() {
		return createOrgIds;
	}
	public void setCreateOrgIds(List<String> createOrgIds) {
		this.createOrgIds = createOrgIds;
	}
	public String getIsdeleted() {
		return isdeleted;
	}
	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}
	public Integer getRn() {
		return rn;
	}
	public void setRn(Integer rn) {
		this.rn = rn;
	}
	public int getSortNumber() {
		return sortNumber;
	}
	public void setSortNumber(int sortNumber) {
		this.sortNumber = sortNumber;
	}
	public String getPaginationEnable() {
		return paginationEnable;
	}
	public void setPaginationEnable(String paginationEnable) {
		this.paginationEnable = paginationEnable;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public Integer getStart_num() {
		return (page-1)*rows;
	} 
	public Integer getEnd_num() {
		return (page-1)*rows + rows;
	} 
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	public String getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}
	public String getAction_name() {
		return action_name;
	}
	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public String getReturnInfo() {
		return returnInfo;
	}
	public void setReturnInfo(String returnInfo) {
		this.returnInfo = returnInfo;
	}
	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		this.res = res;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getLogId() {
		return logId;
	}
	public void setLogId(String logId) {
		this.logId = logId;
	}
	public String getLogContent() {
		return logContent;
	}
	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKeyWords() {
		return keyWords;
	}
	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getCreateTime() {
		if(!"".equals(createTime)&&createTime!=null&&createTime.contains(".0")){
			createTime = createTime.replace(".0", "");
		}
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getVersion_time() {
		if(!"".equals(versionTime)&&versionTime!=null&&versionTime.contains(".0")){
			versionTime = versionTime.replace(".0", "");
		}
		return versionTime;
	}
	public void setVersionTime(String versionTime) {
		this.versionTime = versionTime;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	public String getCreatorName() {
		return creatorName;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	public String getCreateOrgId() {
		return createOrgId;
	}
	public void setCreateOrgId(String createOrgId) {
		this.createOrgId = createOrgId;
	}
	public String getCreateOrgName() {
		return createOrgName;
	}
	public void setCreateOrgName(String createOrgName) {
		this.createOrgName = createOrgName;
	}
	public String getVersionTime() {
		return versionTime;
	}
	public String getTemp_str1() {
		return temp_str1;
	}
	public void setTemp_str1(String temp_str1) {
		this.temp_str1 = temp_str1;
	}
	public String getTemp_str2() {
		return temp_str2;
	}
	public void setTemp_str2(String temp_str2) {
		this.temp_str2 = temp_str2;
	}
	public String getTemp_str3() {
		return temp_str3;
	}
	public void setTemp_str3(String temp_str3) {
		this.temp_str3 = temp_str3;
	}
	
}
