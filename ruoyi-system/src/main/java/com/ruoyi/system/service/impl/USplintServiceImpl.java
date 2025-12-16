package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.USplintMapper;
import com.ruoyi.system.domain.USplint;
import com.ruoyi.system.service.IUSplintService;
import com.ruoyi.common.core.text.Convert;

/**
 * 夹板Service业务层处理
 * 
 * @author pengweitao
 * @date 2025-06-28
 */
@Service
public class USplintServiceImpl implements IUSplintService 
{
    @Autowired
    private USplintMapper uSplintMapper;

    /**
     * 查询夹板
     * 
     * @param id 夹板主键
     * @return 夹板
     */
    @Override
    public USplint selectUSplintById(Long id)
    {
        return uSplintMapper.selectUSplintById(id);
    }

    /**
     * 查询夹板列表
     * 
     * @param uSplint 夹板
     * @return 夹板
     */
    @Override
    public List<USplint> selectUSplintList(USplint uSplint)
    {
        return uSplintMapper.selectUSplintList(uSplint);
    }

    /**
     * 新增夹板
     * 
     * @param uSplint 夹板
     * @return 结果
     */
    @Override
    public int insertUSplint(USplint uSplint)
    {
        return uSplintMapper.insertUSplint(uSplint);
    }

    /**
     * 修改夹板
     * 
     * @param uSplint 夹板
     * @return 结果
     */
    @Override
    public int updateUSplint(USplint uSplint)
    {
        return uSplintMapper.updateUSplint(uSplint);
    }

    /**
     * 批量删除夹板
     * 
     * @param ids 需要删除的夹板主键
     * @return 结果
     */
    @Override
    public int deleteUSplintByIds(String ids)
    {
        return uSplintMapper.deleteUSplintByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除夹板信息
     * 
     * @param id 夹板主键
     * @return 结果
     */
    @Override
    public int deleteUSplintById(Long id)
    {
        return uSplintMapper.deleteUSplintById(id);
    }
}
