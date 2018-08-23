package com.bw.fit.component.warn.dao;

import java.util.List;

import com.bw.fit.component.warn.entity.TWarn;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.position.model.Position;

public interface WarnDao {

	/****
	 * 获取通知列表
	 * @param tw
	 * @return
	 */
	public List<TWarn> all(TWarn tw);
	/****
	 * 修改TWarn
	 * @param tw
	 * @throws RbackException
	 */
	public void update(TWarn tw) throws RbackException ;
}
