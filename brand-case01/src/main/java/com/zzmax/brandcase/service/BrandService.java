package com.zzmax.brandcase.service;

import com.zzmax.brandcase.pojo.Brand;
import com.zzmax.brandcase.pojo.PageBean;

import java.util.List;

public interface BrandService {
    /**
     * 查询所有
     * @return
     */
    List<Brand> selectAll();

    /**
     * 添加数据
     */
    void add(Brand brand);
    /**
     * 批量删除
     */
    void deleteByIds(int[] ids);
    /**
     * 分页查询
     */
    PageBean<Brand> selectByPage(int currentPage,int pageSize);
    /**
     * 分页条件查询
     */
    PageBean<Brand> selectByPageAndCondition(int currentPage,int pageSize,Brand brand);

}
