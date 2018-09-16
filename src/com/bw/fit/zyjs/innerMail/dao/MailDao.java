package com.bw.fit.zyjs.innerMail.dao;

import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.zyjs.innerMail.entity.TMail;

public interface MailDao {

	public void insert(TMail tm) throws RbackException ;
}
