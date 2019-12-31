package com.zhangsan.week1.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhangsan.week1.domain.Brand;
import com.zhangsan.week1.domain.Goods;
import com.zhangsan.week1.domain.Type;

public interface GoodsService {
    //
	PageInfo<Goods> selects(Goods goods ,Integer page,Integer pageSize);
	
	//增加商品
		int  insert(Goods goods);
		
		//所有类型
		List<Type >selectTypes();
		//品牌
		List<Brand>selectBrands();
}
