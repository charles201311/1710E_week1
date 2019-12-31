package com.zhangsan.week1.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.zhangsan.week1.domain.Brand;
import com.zhangsan.week1.domain.Goods;
import com.zhangsan.week1.domain.Type;
import com.zhangsan.week1.service.GoodsService;

@Controller
public class GoodsController {
	@Resource
	private GoodsService goodsService;
	
	@RequestMapping("goods")
	public String goods(Model model, Goods goods,@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "3") Integer pageSize) {
		PageInfo<Goods> info = goodsService.selects(goods, page, pageSize);
		model.addAttribute("info", info);
		model.addAttribute("goods", goods);
		
		return "goods";
	}
	
	//跳转到增加页面 //只支持get请求
	@GetMapping("add")
	public  String add() {
		
		return "add";
	}
	//执行增加
	@ResponseBody
	@PostMapping("add")
	public boolean add(Goods goods,MultipartFile file) {
		//判断是否上传文件
		if(null!=file && !file.isEmpty()) {
			String path="d:/week1/";
			//为了反正文件名称重复。改变上传 的文件名称 a.jpg
			String oldFileName = file.getOriginalFilename();
			String fileName =UUID.randomUUID() + oldFileName.substring(oldFileName.lastIndexOf("."));
			File f = new File(path ,fileName);
			try {//写入硬盘
				file.transferTo(f);
				//商品图片的地址名称
				goods.setPic(fileName);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return goodsService.insert(goods) >0;
	}
	//类型
	@ResponseBody
	@GetMapping("selectTypes")
	public List<Type> selectTypes(){
		return goodsService.selectTypes();
	}
	
	///品牌
	@ResponseBody
	@GetMapping("selectBrands")
	public List<Brand> selectBrands(){
		return goodsService.selectBrands();
	}
}
