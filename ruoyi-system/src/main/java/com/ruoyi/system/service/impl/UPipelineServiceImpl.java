package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UPipelineMapper;
import com.ruoyi.system.domain.UPipeline;
import com.ruoyi.system.service.IUPipelineService;
import com.ruoyi.common.core.text.Convert;

/**
 * 接管类型Service业务层处理
 * 
 * @author pengweitao
 * @date 2025-06-28
 */
@Service
public class UPipelineServiceImpl implements IUPipelineService 
{
    @Autowired
    private UPipelineMapper uPipelineMapper;

    /**
     * 查询接管类型
     * 
     * @param id 接管类型主键
     * @return 接管类型
     */
    @Override
    public UPipeline selectUPipelineById(Long id)
    {
        return uPipelineMapper.selectUPipelineById(id);
    }

    /**
     * 查询接管类型列表
     * 
     * @param uPipeline 接管类型
     * @return 接管类型
     */
    @Override
    public List<UPipeline> selectUPipelineList(UPipeline uPipeline)
    {
        return uPipelineMapper.selectUPipelineList(uPipeline);
    }

    /**
     * 新增接管类型
     * 
     * @param uPipeline 接管类型
     * @return 结果
     */
    @Override
    public int insertUPipeline(UPipeline uPipeline)
    {
        return uPipelineMapper.insertUPipeline(uPipeline);
    }

    /**
     * 修改接管类型
     * 
     * @param uPipeline 接管类型
     * @return 结果
     */
    @Override
    public int updateUPipeline(UPipeline uPipeline)
    {
        return uPipelineMapper.updateUPipeline(uPipeline);
    }

    /**
     * 批量删除接管类型
     * 
     * @param ids 需要删除的接管类型主键
     * @return 结果
     */
    @Override
    public int deleteUPipelineByIds(String ids)
    {
        return uPipelineMapper.deleteUPipelineByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除接管类型信息
     * 
     * @param id 接管类型主键
     * @return 结果
     */
    @Override
    public int deleteUPipelineById(Long id)
    {
        return uPipelineMapper.deleteUPipelineById(id);
    }
}
