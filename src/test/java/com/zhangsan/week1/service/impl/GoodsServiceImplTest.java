package com.zhangsan.week1.service.impl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageInfo;
import com.zhangsan.week1.domain.Goods;
import com.zhangsan.week1.service.GoodsService;

public class GoodsServiceImplTest {

	
	@Test
	public void testSelects() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-beans.xml");
		
		GoodsService service = ac.getBean(GoodsService.class);
		PageInfo<Goods> info = service.selects(null, 1, 3);
		System.out.println(info);
		
		
	}

}
