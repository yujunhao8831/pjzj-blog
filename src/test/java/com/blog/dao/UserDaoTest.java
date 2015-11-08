package com.blog.dao;/**
 * Created by apple on 15/10/23.
 */

import com.blog.dao.base.BaseDaoTest;
import com.blog.domain.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * com.blog
 *
 * @author : 余峻豪
 * @date : 15/10/23
 */
public class UserDaoTest extends BaseDaoTest {

    private UserDao dao;
    @Before
    public void before () {
        dao = act.getBean(UserDao.class);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setUsername("李美琪");
        user.setPassword("limeiqi");
        dao.insert(user);
        System.err.println("id = " + user.getId());
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(1L);
        user.setUsername("superAdmin");
        user.setPassword("superAdmin");
        dao.update(user);
    }


    @Test
    public void testSelect () throws Exception {

        User user = dao.selectById(1L);
        System.err.println("user = " + user);
        user = dao.selectById(4L);
        System.err.println("user = " + user);
    }

    @Test
    public void testDelete () throws Exception {
        boolean result = dao.delete(4L);
        System.err.println("result = " + result );
    }

    @Test
    public void testSelectByIds () throws Exception {
        List<User> users = dao.selectByIds(new Long[]{1L, 2L, 3L});
        System.err.println("users = " + users);
    }

    @Test
    public void testSelectAll () throws Exception {
        List<User> users = dao.selectAll();
        System.err.println("users = " + users);
    }


    @Test
    public void testSelectUserHistoryByUserId () throws Exception {
        User user = dao.selectUserHistoryByUserId(1L);
        System.err.println("user = " + user);
    }


    @Test
    public void testSelectUserHistoryListByUserId () throws Exception {
        dao.selectSelectUserHistoryListByUserId(1L);
    }
}




