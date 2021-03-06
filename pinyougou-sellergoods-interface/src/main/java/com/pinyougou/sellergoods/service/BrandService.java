package com.pinyougou.sellergoods.service;

import java.util.List;

import com.pinyougou.pojo.TbBrand;

import entity.PageResult;

/**
 * 品牌接口
 */
public interface BrandService {
	/**
	 * 返回全部列表
	 */
	public List<TbBrand> findAll();

	/**
	 * 品牌分页
	 * 
	 * @param pageNum
	 *            当前页码
	 * @param pageSize
	 *            每页记录数
	 * @return
	 */

	public PageResult findPage(int pageNum, int pageSize);
	
	/**
	 * 增加品牌
	 */
	
	public void add(TbBrand brand);
}
