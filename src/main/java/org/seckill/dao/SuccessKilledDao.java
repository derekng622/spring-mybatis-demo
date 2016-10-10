package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

/**
 * Created by wudeh on 2016/7/21.
 */
public interface SuccessKilledDao {

    /**
     * 插入购买明细,可过滤重复
     * @param seckillId
     * @param userPhone
     * @return
     */
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

    /**
     * 根据Id查询SuccessKilled并携带秒杀对象实体
     * @param seckillId
     * @return
     */
    SuccessKilled queryById(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
}
