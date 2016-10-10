package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by wudeh on 2016/10/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

    @Resource
    private SuccessKilledDao successKilledDao;

    @Test
    public void testInsertSuccessKilled() throws Exception {
        int affectedCount = successKilledDao.insertSuccessKilled(1000L, 18588867008L);
        assertEquals(1, affectedCount);
        affectedCount = successKilledDao.insertSuccessKilled(1000L, 18588867008L);
        assertEquals(0, affectedCount);
    }

    @Test
    public void testQueryById() throws Exception {
        SuccessKilled successKilled = successKilledDao.queryById(1000L, 18588867008L);
        assertNotNull(successKilled);
        System.out.println(successKilled.getState());
        System.out.println(successKilled.getSeckill().getName());
    }
}