package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AfterSalesMapper;
import com.ruoyi.system.domain.AfterSales;
import com.ruoyi.system.service.IAfterSalesService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-20
 */
@Service
public class AfterSalesServiceImpl implements IAfterSalesService 
{
    @Autowired
    private AfterSalesMapper afterSalesMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public AfterSales selectAfterSalesById(Long id)
    {
        return afterSalesMapper.selectAfterSalesById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param afterSales 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<AfterSales> selectAfterSalesList(AfterSales afterSales)
    {
        return afterSalesMapper.selectAfterSalesList(afterSales);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param afterSales 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertAfterSales(AfterSales afterSales)
    {
        afterSales.setCreateTime(DateUtils.getNowDate());
        return afterSalesMapper.insertAfterSales(afterSales);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param afterSales 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateAfterSales(AfterSales afterSales)
    {
        return afterSalesMapper.updateAfterSales(afterSales);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteAfterSalesByIds(String ids)
    {
        return afterSalesMapper.deleteAfterSalesByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteAfterSalesById(Long id)
    {
        return afterSalesMapper.deleteAfterSalesById(id);
    }
}
