package com.blog.core.base;


import java.io.Serializable;
import java.util.List;


/**
 * <p>
 * 所有Dao的基类
 * 所有的增删改查以及分页的实现
 * 子类如有特殊业务需求,自行添加即可
 * </p>
 * <p>@author 余峻豪</p>
 * <p>@param <M>  : 模型(实体)</p>
 * <p>@param <PK> : ID(映射到数据库的主键类型)</p>
 */
public interface BaseDao<M extends Serializable> {

	/** 增加(当前实体) */
    boolean insert (M model);
	/** 修改(当前实体) */
    boolean update (M model);
	/** 删除(当前实体) */
	boolean delete (Serializable id);
	/** 根据主键查询(当前实体) */
	M selectById (Serializable id);
	/** 根据多个主键查询(当前实体) */
	List<M> selectByIds (Serializable[] ids);
	/** 查询所有(当前实体) */
	List<M> selectAll ();

}
