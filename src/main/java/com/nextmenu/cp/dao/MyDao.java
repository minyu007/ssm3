package com.nextmenu.cp.dao;

import java.io.Serializable;
import java.util.List;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class MyDao extends SqlSessionDaoSupport{

	public void insert(String key, Object obj) {
		getSqlSession().insert(key, obj);
	}

	public void update(String key, Object obj) {
		getSqlSession().update(key, obj);
	}

	public void delete(String key, Serializable id) {
		getSqlSession().delete(key, id);
	}

	@SuppressWarnings("unchecked")
	public <T> T get(String key, Object params) {
		return (T) getSqlSession().selectOne(key, params);
	}

	public <T> List<T> getList(String key) {
		return getSqlSession().selectList(key);
	}

	public <T> List<T> getList(String key, Object params) {
		return getSqlSession().selectList(key, params);
	}
}
