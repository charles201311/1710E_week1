package com.zhangsan.week1.dao;

import java.util.List;

import com.zhangsan.week1.domain.Brand;
import com.zhangsan.week1.domain.Goods;
import com.zhangsan.week1.domain.Type;

public interface GoodsMapper {
	
	List<Goods> selects(Goods goods);

	//������Ʒ
	int  insert(Goods goods);
	//��������
	List<Type >selectTypes();
	//Ʒ��
	List<Brand>selectBrands();
}
