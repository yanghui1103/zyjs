package com.bw.fit.system.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.bw.fit.system.common.util.PubFun.*;

import com.bw.fit.system.account.dao.AccountDao;
import com.bw.fit.system.authority.entity.TRole2dataauth;
import com.bw.fit.system.common.model.BaseModel;
import com.bw.fit.system.dict.dao.DictDao;
import com.bw.fit.system.dict.model.Dict;
import com.bw.fit.system.organization.dao.OrganizationDao;
import com.bw.fit.system.organization.model.Organization;
import com.bw.fit.system.role.dao.RoleDao;
import com.bw.fit.system.role.entity.TRole;

@Component
public class CommonUtil {

	@Autowired
	private AccountDao accountDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private DictDao dictDao;
	@Autowired
	private OrganizationDao organizationDao;
	
	/*****
	 * 填充公共字段
	 * @param b
	 * @param isFillFdid
	 * @param session
	 */
}
