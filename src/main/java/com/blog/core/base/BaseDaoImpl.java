package com.blog.core.base;

import com.blog.core.utils.ReflectBaseGenericsTypesUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;


@SuppressWarnings("unchecked")
public abstract class BaseDaoImpl<M extends Serializable> extends SqlSessionDaoSupport implements BaseDao<M> {

	protected final  Class<M> modelClass;

	public BaseDaoImpl() {
		// 通过ReflectBaseGenericsTypesUtil.getBaseGenericsTypes得到 Model
		this.modelClass = ReflectBaseGenericsTypesUtil.getBaseGenericsTypes(this.getClass());
	}

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public boolean insert (M model) {
		return getSqlSession().insert(modelClass.getName() + ".insert", model) > 0;
	}

	@Override
	public boolean update (M model) {
		return getSqlSession().update(modelClass.getName() + ".update", model) > 0;
	}

	@Override
	public boolean delete (Serializable id) {
		return getSqlSession().delete(modelClass.getName() + ".delete",id) > 0;
	}

	@Override
	public M selectById (Serializable id) {
		return getSqlSession().selectOne(modelClass.getName() + ".selectById",id);
	}

	@Override
	public List<M> selectByIds (Serializable[] ids) {
		return getSqlSession().selectList(modelClass.getName() + ".selectByIds",ids);
	}

	@Override
	public List<M> selectAll () {
		return getSqlSession().selectList(modelClass.getName() + ".selectAll");
	}
}
