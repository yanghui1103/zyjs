package com.bw.fit.zyjs.company.dao;

import java.util.List;

import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.zyjs.company.entity.TEsta;

public interface EstaDao {

	public List<TEsta> selectAll(TEsta te);
	
	/****
	 * 修改外部账号状态
	 * @param id
	 * @param isdeleted
	 * @throws RbackException
	 */
	public void updateExtenalUserStatus(String id,String isdeleted,String tableName) throws RbackException ;
	/****
	 * 查询其类型，个人/企业
	 * @param id
	 * @return
	 */
	public String getExtenalType(String id);
	/*****
	 * 获取
	 * @param id
	 * @return
	 */
	public TEsta get(String id);
	/****
	 * 初始化密码
	 * @param id 外部用户ID
	 * @param passwdmm
	 */
	public void initPasswd(String id,String passwdmm) throws RbackException ;
	/****
	 * 获取外部主体
	 * @param id
	 * @return
	 */
	public TEsta getSubject(String id);
	/****
	 * 获取企业
	 * @param id
	 * @return
	 */
	public TEsta getOne(String id);
}
