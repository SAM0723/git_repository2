package com.pinyougou.manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

import entity.PageResult;
import entity.Result;

/**
 * 品牌controller
 */
@RestController
@RequestMapping("/brand")
public class BrandController {
	@Reference
	private BrandService brandService;

	/**
	 * 返回全部列表
	 */
	// 指定路径
	@RequestMapping("/findAll")
	public List<TbBrand> findAll() {
		return brandService.findAll();
	}
	/*
	 * 返回分页
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page,int size) {
		return brandService.findPage(page,size);
	}
	
	/**
	 * 增加品牌
	 * 两种方法实现:
	 * 1. Map map = new HashMap();
	 * 		 map.put('success',true);
	 * 		 map.put('message',"保存成功")；
	 * 		 return map;
	 * 2.创建实体类result
	 * 		包含success和message
	 * 
	 * 校验重复有两种方法：
	 * 1.在数据库加入约束文件校验重复
	 * 2.在这里方法中加入判断
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbBrand brand){
		try {
			brandService.add(brand);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
		
	}
	
}
