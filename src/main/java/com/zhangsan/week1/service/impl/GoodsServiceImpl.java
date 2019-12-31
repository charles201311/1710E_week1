package com.zhangsan.week1.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangsan.week1.dao.GoodsMapper;
import com.zhangsan.week1.domain.Brand;
import com.zhangsan.week1.domain.Goods;
import com.zhangsan.week1.domain.Type;
import com.zhangsan.week1.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Resource
	private GoodsMapper goodsMapper;
	@Override
	public PageInfo<Goods> selects(Goods goods, Integer page, Integer pageSize) {
		
		PageHelper.startPage(page, pageSize);
		List<Goods> list = goodsMapper.selects(goods);
		return new PageInfo<Goods>(list);
	}
	@Override
	public int insert(Goods goods) {
		// TODO Auto-generated method stub
		return goodsMapper.insert(goods);
	}
	@Override
	public List<Type> selectTypes() {
		// TODO Auto-generated method stub
		return goodsMapper.selectTypes();
	}
	@Override
	public List<Brand> selectBrands() {
		// TODO Auto-generated method stub
		return goodsMapper.selectBrands();
	}

}
