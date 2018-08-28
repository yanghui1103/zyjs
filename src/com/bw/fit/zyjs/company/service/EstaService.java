package com.bw.fit.zyjs.company.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.zyjs.company.entity.TEsta;

/*****
 * 外部企业管理
 * @author yangh
 *
 */
public interface EstaService {

	public List<TEsta> selectAll(TEsta ta);
	
	/*****
	 * 禁用外部用户
	 * @param id
	 * @return
	 * @throws RbackException
	 */
	public JSONObject forbiddenExtenalUser(String id) throws RbackException ;
	/*****
	 * 启用外部用户
	 * @param id
	 * @return
	 * @throws RbackException
	 */
	public JSONObject startExtenalUser(String id) throws RbackException ;
	/*****
	 * 初始化密码
	 * @param id
	 * @return
	 * @throws RbackException
	 */
	public JSONObject initExtenalUserPwd(String id) throws RbackException ;
	
	
	
}
