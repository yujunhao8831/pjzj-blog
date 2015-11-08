package com.blog.dao;/**
 * Created by apple on 15/10/22.
 */

import com.blog.core.base.BaseDao;
import com.blog.domain.User;

import java.util.List;

/**
 * com.blog.dao
 *
 * @author : 余峻豪
 * @date : 15/10/22
 */
public interface UserDao extends BaseDao<User> {

    User selectUserHistoryByUserId (Long userId);

    List<User> selectSelectUserHistoryListByUserId (Long userId);
}
