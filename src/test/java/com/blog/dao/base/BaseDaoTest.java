package com.blog.dao.base;/**
 * Created by apple on 15/10/23.
 */

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * com.blog.dao
 *
 * @author : 余峻豪
 * @date : 15/10/23
 */
public class BaseDaoTest {

    public ApplicationContext act;

    @Before
    public void init () {
        act = new ClassPathXmlApplicationContext("spring.xml");
    }
    @Test
    public void test () {
        System.err.println("act = " + act);
    }
}
