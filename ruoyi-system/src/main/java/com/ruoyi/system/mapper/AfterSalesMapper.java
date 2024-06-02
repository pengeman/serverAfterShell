package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.AfterSales;

/**
 * AfterSalesMapper接口
 * 
 * @author ruoyi
 * @date 2024-05-11
 */
public interface AfterSalesMapper 
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
     * 删除AfterSales
     * 
     * @param id AfterSales主键
     * @return 结果
     */
    public int deleteAfterSalesById(Long id);

    /**
     * 批量删除AfterSales
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAfterSalesByIds(String[] ids);
}
