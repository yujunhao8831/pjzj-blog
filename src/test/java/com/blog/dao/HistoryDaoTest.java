package com.blog.dao;/**
 * Created by apple on 15/10/23.
 */

import com.blog.core.enums.HistoryEnum;
import com.blog.dao.base.BaseDaoTest;
import com.blog.domain.History;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * com.blog
 *
 * @author : 余峻豪
 * @date : 15/10/23
 */
public class HistoryDaoTest extends BaseDaoTest {

    private HistoryDao dao;

    @Before
    public void before () {
        dao = act.getBean(HistoryDao.class);
    }

    @Test
    public void testInsert() throws ParseException {
        History history = new History();
        history.setParentId(1L);
        history.setHistoryMessage("测试2");
        history.setHistoryType(HistoryEnum.USER.getType());
        System.err.println("history = " + history);
        dao.insert(history);
        System.err.println("id = " + history.getId());
    }

    @Test
    public void testUpdate() {
        History history = new History();
        history.setId(1L);
        history.setHistoryDate(new Date());
        history.setHistoryType(HistoryEnum.USER.getType());
        history.setHistoryMessage("修改了");
        dao.update(history);
    }


    @Test
    public void testSelect () throws Exception {
        History history = dao.selectById(1L);
        System.err.println("History = " + history);
    }

    @Test
    public void testDelete () throws Exception {
        boolean result = dao.delete(1L);
        System.err.println("result = " + result );
    }

    @Test
    public void testSelectByIds () throws Exception {
        List<History> Historys = dao.selectByIds(new Long[]{1L, 2L, 3L});
        System.err.println("Historys = " + Historys);
    }

    @Test
    public void testSelectAll () throws Exception {
        List<History> Historys = dao.selectAll();
        System.err.println("Historys = " + Historys);
    }





}




