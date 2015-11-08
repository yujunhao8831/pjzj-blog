package com.blog.service.impl;

import com.blog.core.base.BaseServiceImpl;
import com.blog.dao.UserDao;
import com.blog.service.UserService;
import com.blog.domain.User;
import org.springframework.stereotype.Service;

/**
 * com.blog.service
 *
 * @author : 余峻豪
 * @date : 15/10/22
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User,UserDao> implements UserService {

}
