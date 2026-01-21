package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BreakdownMapper;
import com.ruoyi.system.domain.Breakdown;
import com.ruoyi.system.service.IBreakdownService;
import com.ruoyi.common.core.text.Convert;

/**
 * 故障类型字典Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-17
 */
@Service
public class BreakdownServiceImpl implements IBreakdownService 
{
    @Autowired
    private BreakdownMapper breakdownMapper;

    /**
     * 查询故障类型字典
     * 
     * @param id 故障类型字典主键
     * @return 故障类型字典
     */
    @Override
    public Breakdown selectBreakdownById(Long id)
    {
        return breakdownMapper.selectBreakdownById(id);
    }

    /**
     * 查询故障类型字典列表
     * 
     * @param breakdown 故障类型字典
     * @return 故障类型字典
     */
    @Override
    public List<Breakdown> selectBreakdownList(Breakdown breakdown)
    {
        return breakdownMapper.selectBreakdownList(breakdown);
    }

    /**
     * 新增故障类型字典
     * 
     * @param breakdown 故障类型字典
     * @return 结果
     */
    @Override
    public int insertBreakdown(Breakdown breakdown)
    {
        return breakdownMapper.insertBreakdown(breakdown);
    }

    /**
     * 修改故障类型字典
     * 
     * @param breakdown 故障类型字典
     * @return 结果
     */
    @Override
    public int updateBreakdown(Breakdown breakdown)
    {
        return breakdownMapper.updateBreakdown(breakdown);
    }

    /**
     * 批量删除故障类型字典
     * 
     * @param ids 需要删除的故障类型字典主键
     * @return 结果
     */
    @Override
    public int deleteBreakdownByIds(String ids)
    {
        return breakdownMapper.deleteBreakdownByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除故障类型字典信息
     * 
     * @param id 故障类型字典主键
     * @return 结果
     */
    @Override
    public int deleteBreakdownById(Long id)
    {
        return breakdownMapper.deleteBreakdownById(id);
    }
}
