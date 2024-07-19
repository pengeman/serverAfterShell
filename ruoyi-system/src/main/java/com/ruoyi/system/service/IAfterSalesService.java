package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.AfterSales;

/**
 * afterSalesService接口
 * 
 * @author peng
 * @date 2024-07-04
 */
public interface IAfterSalesService 
{
    /**
     * 查询afterSales
     * 
     * @param id afterSales主键
     * @return afterSales
     */
    public AfterSales selectAfterSalesById(Long id);

    /**
     * 查询afterSales列表
     * 
     * @param afterSales afterSales
     * @return afterSales集合
     */
    public List<AfterSales> selectAfterSalesList(AfterSales afterSales);

    /**
     * 新增afterSales
     * 
     * @param afterSales afterSales
     * @return 结果
     */
    public int insertAfterSales(AfterSales afterSales);

    /**
     * 修改afterSales
     * 
     * @param afterSales afterSales
     * @return 结果
     */
    public int updateAfterSales(AfterSales afterSales);

    /**
     * 批量删除afterSales
     * 
     * @param ids 需要删除的afterSales主键集合
     * @return 结果
     */
    public int deleteAfterSalesByIds(String ids);

    /**
     * 删除afterSales信息
     * 
     * @param id afterSales主键
     * @return 结果
     */
    public int deleteAfterSalesById(Long id);

    /**
     * by peng
     * 导入售后单，from json
     */
    public int importAfterSalesFromJson(String afterSalesJson);
}
