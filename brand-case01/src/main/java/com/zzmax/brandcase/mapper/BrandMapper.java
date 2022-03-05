package com.zzmax.brandcase.mapper;

import com.zzmax.brandcase.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @description:
 * @author: mqxu
 * @date: 2022-02-28
 **/
public interface BrandMapper {
    /**
     * 查询所有
     *
     * @return List<Brand>
     */
    @Select("SELECT * FROM tb_brand ORDER BY ordered ")
    List<Brand> selectAll();

    /**
     * 新增
     *
     * @param brand brand对象
     */
    @Insert("INSERT INTO tb_brand VALUES (null,#{brandName},#{companyName},#{ordered},#{description},#{status}) ")
    void add(Brand brand);

    @Delete("DELETE FROM tb_brand WHERE id = #{id}")
    void delete(Brand brand);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);

    /**
     * 分页查询
     */
    @Select("SELECT * FROM tb_brand LIMIT #{begin},#{size}}")
    List<Brand> selectByPage(@Param("begin") int begin,@Param("size") int size);

    /**
     * 查询总记录
     */
    @Select("SELECT COUNT(*) FROM tb_brand)")
    int selectTotalCount();

    /**
     * 根据id查询
     *
     * @param id 主键id
     * @return Brand对象
     */
    @Select("SELECT * FROM tb_brand WHERE id = #{id} ")
    Brand selectById(int id);

    /**
     * 分页查询条件
     */
    List<Brand> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("brand") Brand brand);

    /**
     * 根据条件查询查询总记录
     */
    int selectTotalCountByCondition(Brand brand);

    /**
     * 修改
     *
     * @param brand brand对象
     */
    @Update("UPDATE tb_brand SET brand_name = #{brandName},company_name = #{companyName},ordered = #{ordered},description = #{description},status = #{status} WHERE id = #{id} ")
    void update(Brand brand);
}
