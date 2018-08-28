package com.bw.fit.zyjs.audit.dao;

import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.zyjs.audit.entity.TAudit;

public interface AuditDao {

	public void create(TAudit ta) throws RbackException;
}
