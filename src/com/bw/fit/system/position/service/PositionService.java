package com.bw.fit.system.position.service;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.position.model.Position;

public interface PositionService {
	/****
	 * 新增岗位
	 * @param position
	 * @return
	 * @throws RbackException
	 */
	public JSONObject createPosition(Position position) throws RbackException ;
	/****
	 * 删除岗位
	 * @param position
	 * @return
	 * @throws RbackException
	 */
	public JSONObject deletePosition(String id,String orgId) throws RbackException ;
	/****
	 * 修改岗位
	 * @param position
	 * @return
	 * @throws RbackException
	 */
	public JSONObject updatePosition(Position position) throws RbackException ;
	
	/****
	 * 获取岗位
	 * @param id 岗位id
	 * @return
	 */
	public Position get(String id);
}
