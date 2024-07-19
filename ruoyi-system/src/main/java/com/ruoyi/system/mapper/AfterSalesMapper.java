package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.AfterSales;

/**
 * afterSalesMapper接口
 * 
 * @author peng
 * @date 2024-07-04
 */
public interface AfterSalesMapper 
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
     * 删除afterSales
     * 
     * @param id afterSales主键
     * @return 结果
     */
    public int deleteAfterSalesById(Long id);

    /**
     * 批量删除afterSales
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAfterSalesByIds(String[] ids);
}
