package com.bw.fit.system.position.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bw.fit.system.common.model.RbackException;
import com.bw.fit.system.common.util.PubFun;
import com.bw.fit.system.position.dao.PositionDao;
import com.bw.fit.system.position.entity.TOrganization2Position;
import com.bw.fit.system.position.model.Position;
import com.bw.fit.system.position.service.PositionService;
@Service
public class PositionServiceImpl implements PositionService{
	@Autowired
	private PositionDao positionDao ;

	@Override
	public JSONObject createPosition(Position position) throws RbackException {
		JSONObject json = new JSONObject();		
		try {
			positionDao.insert(position);
			PubFun.returnSuccessJson(json);
			String [] ids = position.getTemp_str1().split(",");
			if(ids.length>0) {
				for(String orgId : ids) {
					TOrganization2Position to2p = new TOrganization2Position();
					to2p.setPositionId(position.getId());
					to2p.setOrgId(orgId);
					positionDao.insertOrg2Position(to2p);
				}
			}
		} catch (RbackException e) {
			e.printStackTrace();
			json = new JSONObject();
			PubFun.returnFailJson(json, e.getMsg());
			throw   e;
		}finally{
			return json ;
		}
	}

	@Override
	public JSONObject updatePosition(Position position) throws RbackException {
		JSONObject json = new JSONObject();		
		try {
			positionDao.update(position);
			positionDao.deleteO2PByPid(position.getId());
			String tmpIds = position.getTemp_str1();
			if(tmpIds.indexOf(",")!=-1) {
				String [] ids = tmpIds.split(",");
				if(ids.length>0) {
					for(String orgId : ids) {
						TOrganization2Position to2p = new TOrganization2Position();
						to2p.setPositionId(position.getId());
						to2p.setOrgId(orgId);
						positionDao.insertOrg2Position(to2p);
					}
				}
			}else {
				TOrganization2Position to2p = new TOrganization2Position();
				to2p.setPositionId(position.getId());
				to2p.setOrgId(tmpIds);
				positionDao.insertOrg2Position(to2p);
			}
			
			PubFun.returnSuccessJson(json);
		} catch (RbackException e) {
			e.printStackTrace();
			json = new JSONObject();
			PubFun.returnFailJson(json, e.getMsg());
			throw   e;
		}finally{
			return json ;
		}
	}

	@Override
	public JSONObject deletePosition(String id,String orgId) throws RbackException {
		JSONObject json = new JSONObject();		
		try {
			positionDao.deleteO2P(id,orgId);
			List<TOrganization2Position> aaa= positionDao.checkO2P(id);
			if(aaa==null||aaa.size()<=0) {
				positionDao.delete(id);
			}
			PubFun.returnSuccessJson(json);
		} catch (RbackException e) {
			e.printStackTrace();
			json = new JSONObject();
			PubFun.returnFailJson(json, e.getMsg());
			throw   e;
		}finally{
			return json ;
		}
	}

	@Override
	public Position get(String id) {
		return positionDao.get(id);
	}
	

}
