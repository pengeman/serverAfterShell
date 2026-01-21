package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.USplint;

/**
 * 夹板Mapper接口
 * 
 * @author pengweitao
 * @date 2025-06-28
 */
public interface USplintMapper 
{
    /**
     * 查询夹板
     * 
     * @param id 夹板主键
     * @return 夹板
     */
    public USplint selectUSplintById(Long id);

    /**
     * 查询夹板列表
     * 
     * @param uSplint 夹板
     * @return 夹板集合
     */
    public List<USplint> selectUSplintList(USplint uSplint);

    /**
     * 新增夹板
     * 
     * @param uSplint 夹板
     * @return 结果
     */
    public int insertUSplint(USplint uSplint);

    /**
     * 修改夹板
     * 
     * @param uSplint 夹板
     * @return 结果
     */
    public int updateUSplint(USplint uSplint);

    /**
     * 删除夹板
     * 
     * @param id 夹板主键
     * @return 结果
     */
    public int deleteUSplintById(Long id);

    /**
     * 批量删除夹板
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUSplintByIds(String[] ids);
}
