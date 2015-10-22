package com.blog.core.base;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;


public abstract class BaseServiceImpl<M extends Serializable,DAO extends BaseDao<M>> implements BaseService<M,DAO> {

	@Autowired
	protected DAO dao;

	@Override
	public boolean insert (M model) {
		return dao.insert(model);
	}

	@Override
	public boolean update (M model) {
		return dao.update(model);
	}

	@Override
	public boolean delete (Serializable id) {
		return dao.delete(id);
	}

	@Override
	public M selectById (Serializable id) {
		return dao.selectById(id);
	}

	@Override
	public List<M> selectByIds (Serializable[] ids) {
		return dao.selectByIds(ids);
	}

	@Override
	public List<M> selectAll () {
		return dao.selectAll();
	}
}
