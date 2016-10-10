package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wudeh on 2016/10/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    @Autowired
    private SeckillDao seckillDao;

    @Test
    public void testReduceNumber() throws Exception {
        int affectedCount = seckillDao.reduceNumber(1000, new Date("2016-07-21 00:00:00"));
        assertEquals(1, affectedCount);
    }

    @Test
    public void testQueryById() throws Exception {
        int id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        assertNotNull(seckill);
    }

    @Test
    public void testQueryAll() throws Exception {
        List<Seckill> list = seckillDao.queryAll(0, 100);
        assertEquals(4, list.size());
    }
}