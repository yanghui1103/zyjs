package com.bw.fit.system.common.dao;

import com.bw.fit.system.common.data.source.KvdbDataSource;
import com.bw.fit.system.common.data.source.MqDataSource;
import com.bw.fit.system.common.data.source.NoSQLDataSource;
import com.bw.fit.system.common.data.source.RmdbDataSource;

public interface DaoTemplete extends MqDataSource,  KvdbDataSource,
		RmdbDataSource ,NoSQLDataSource{

	public void join();
}
