package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.AfterSales;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-20
 */
public interface AfterSalesMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public AfterSales selectAfterSalesById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param afterSales 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<AfterSales> selectAfterSalesList(AfterSales afterSales);

    /**
     * 新增【请填写功能名称】
     * 
     * @param afterSales 【请填写功能名称】
     * @return 结果
     */
    public int insertAfterSales(AfterSales afterSales);

    /**
     * 修改【请填写功能名称】
     * 
     * @param afterSales 【请填写功能名称】
     * @return 结果
     */
    public int updateAfterSales(AfterSales afterSales);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteAfterSalesById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAfterSalesByIds(String[] ids);
}
