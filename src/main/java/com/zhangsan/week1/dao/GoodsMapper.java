package com.zhangsan.week1.dao;

import java.util.List;

import com.zhangsan.week1.domain.Brand;
import com.zhangsan.week1.domain.Goods;
import com.zhangsan.week1.domain.Type;

public interface GoodsMapper {
	
	List<Goods> selects(Goods goods);

	//增加商品
	int  insert(Goods goods);
	//所有类型
	List<Type >selectTypes();
	//品牌
	List<Brand>selectBrands();
}
