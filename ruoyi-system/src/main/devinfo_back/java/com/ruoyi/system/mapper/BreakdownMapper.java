package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Breakdown;

/**
 * 故障类型字典Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-17
 */
public interface BreakdownMapper 
{
    /**
     * 查询故障类型字典
     * 
     * @param id 故障类型字典主键
     * @return 故障类型字典
     */
    public Breakdown selectBreakdownById(Long id);

    /**
     * 查询故障类型字典列表
     * 
     * @param breakdown 故障类型字典
     * @return 故障类型字典集合
     */
    public List<Breakdown> selectBreakdownList(Breakdown breakdown);

    /**
     * 新增故障类型字典
     * 
     * @param breakdown 故障类型字典
     * @return 结果
     */
    public int insertBreakdown(Breakdown breakdown);

    /**
     * 修改故障类型字典
     * 
     * @param breakdown 故障类型字典
     * @return 结果
     */
    public int updateBreakdown(Breakdown breakdown);

    /**
     * 删除故障类型字典
     * 
     * @param id 故障类型字典主键
     * @return 结果
     */
    public int deleteBreakdownById(Long id);

    /**
     * 批量删除故障类型字典
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBreakdownByIds(String[] ids);
}
