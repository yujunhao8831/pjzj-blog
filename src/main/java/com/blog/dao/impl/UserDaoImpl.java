package com.blog.dao.impl;
/**
 * Created by apple on 15/10/22.
 */

import com.blog.dao.UserDao;
import com.blog.core.base.BaseDaoImpl;
import com.blog.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * com.blog.dao.impl
 *
 * @author : 余峻豪
 * @date : 15/10/22
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    @Override
    public User selectUserHistoryByUserId (Long userId) {
        return getSqlSession().selectOne(modelClass.getName() + ".selectUserHistoryByUserId", userId);
    }

    @Override
    public List<User> selectSelectUserHistoryListByUserId (Long userId) {
        return getSqlSession().selectList(modelClass.getName() + ".selectUserHistoryByUserId", userId);
    }
}

