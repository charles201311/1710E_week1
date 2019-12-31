package com.zhangsan.week1.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhangsan.week1.domain.Brand;
import com.zhangsan.week1.domain.Goods;
import com.zhangsan.week1.domain.Type;

public interface GoodsService {
    //
	PageInfo<Goods> selects(Goods goods ,Integer page,Integer pageSize);
	
	//������Ʒ
		int  insert(Goods goods);
		
		//��������
		List<Type >selectTypes();
		//Ʒ��
		List<Brand>selectBrands();
}
