package com.bw.fit.system.menu.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bw.fit.system.common.dao.DaoTemplete;
import com.bw.fit.system.menu.dao.MenuDao;
import com.bw.fit.system.menu.model.Menu;
@Repository
public class MenuDaoImpl implements MenuDao {

	@Autowired
	private DaoTemplete daoTemplete;

	@Override
	public List<Menu> getMenus() {
		return daoTemplete.getListData("menuSql.getMenus", null);
	}

	@Override
	public List<Menu> getMyRole2Menus(String roleId) {
		return daoTemplete.getListData("menuSql.getMyRole2Menus", roleId);
	}
	
	
}
