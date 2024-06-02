package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.AfterSales;

/**
 * AfterSalesService接口
 * 
 * @author ruoyi
 * @date 2024-05-11
 */
public interface IAfterSalesService 
{
    /**
     * 查询AfterSales
     * 
     * @param id AfterSales主键
     * @return AfterSales
     */
    public AfterSales selectAfterSalesById(Long id);

    /**
     * 查询AfterSales列表
     * 
     * @param afterSales AfterSales
     * @return AfterSales集合
     */
    public List<AfterSales> selectAfterSalesList(AfterSales afterSales);

    /**
     * 新增AfterSales
     * 
     * @param afterSales AfterSales
     * @return 结果
     */
    public int insertAfterSales(AfterSales afterSales);

    /**
     * 修改AfterSales
     * 
     * @param afterSales AfterSales
     * @return 结果
     */
    public int updateAfterSales(AfterSales afterSales);

    /**
     * 批量删除AfterSales
     * 
     * @param ids 需要删除的AfterSales主键集合
     * @return 结果
     */
    public int deleteAfterSalesByIds(String ids);

    /**
     * 删除AfterSales信息
     * 
     * @param id AfterSales主键
     * @return 结果
     */
    public int deleteAfterSalesById(Long id);

    /**
     * 导入售后单，from json
     */
    public int importAfterSalesFromJson(String afterSalesJson);
}
