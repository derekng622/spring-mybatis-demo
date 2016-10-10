-- 初始化脚本
-- 创建数据库
CREATE DATABASE seckill;
USE seckill;

-- 创建秒杀表
CREATE TABLE seckill(
`seckill_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '秒杀商品Id',
`name` VARCHAR (120) NOT NULL COMMENT '商品名称',
`number` INT NOT NULL COMMENT '商品数量',
`start_time` TIMESTAMP NOT NULL COMMENT '秒杀开始时间',
`end_time` TIMESTAMP NOT NULL COMMENT '秒杀结束时间',
`create_time` TIMESTAMP NOT NULL COMMENT '秒杀创建时间',
PRIMARY KEY(seckill_id),
KEY idx_start_time(start_time),
KEY idx_end_time(end_time),
KEY idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT '秒杀表';

-- 初始化数据
INSERT INTO seckill (name, number, start_time, end_time, create_time)
VALUES
('1000元秒杀iphone6s', '100', '2016-07-21 00:00:00', '2016-07-22 00:00:00', '2016-07-22 00:00:00'),
('500元秒杀ipad4', '200', '2016-07-21 00:00:00', '2016-07-22 00:00:00', '2016-07-22 00:00:00'),
('3000元秒杀小米4', '300', '2016-07-21 00:00:00', '2016-07-22 00:00:00', '2016-07-22 00:00:00'),
('2000元秒杀红米note', '400', '2016-07-21 00:00:00', '2016-07-22 00:00:00', '2016-07-22 00:00:00');

-- 秒杀明细表
CREATE TABLE success_killed(
  `seckill_id` BIGINT NOT NULL COMMENT '秒杀商品Id',
  `user_phone` BIGINT NOT NULL COMMENT '用户手机号',
  `state` TINYINT NOT NULL DEFAULT -1 COMMENT '状态: -1:无效,0:成功,1:已付款',
  `create_time` TIMESTAMP NOT NULL COMMENT '创建时间',
  PRIMARY KEY (seckill_id, user_phone),
  KEY idx_create_time(create_time)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '秒杀成功明细表';