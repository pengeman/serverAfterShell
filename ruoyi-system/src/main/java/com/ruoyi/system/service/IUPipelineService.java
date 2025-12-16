package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.UPipeline;

/**
 * 接管类型Service接口
 * 
 * @author pengweitao
 * @date 2025-06-28
 */
public interface IUPipelineService 
{
    /**
     * 查询接管类型
     * 
     * @param id 接管类型主键
     * @return 接管类型
     */
    public UPipeline selectUPipelineById(Long id);

    /**
     * 查询接管类型列表
     * 
     * @param uPipeline 接管类型
     * @return 接管类型集合
     */
    public List<UPipeline> selectUPipelineList(UPipeline uPipeline);

    /**
     * 新增接管类型
     * 
     * @param uPipeline 接管类型
     * @return 结果
     */
    public int insertUPipeline(UPipeline uPipeline);

    /**
     * 修改接管类型
     * 
     * @param uPipeline 接管类型
     * @return 结果
     */
    public int updateUPipeline(UPipeline uPipeline);

    /**
     * 批量删除接管类型
     * 
     * @param ids 需要删除的接管类型主键集合
     * @return 结果
     */
    public int deleteUPipelineByIds(String ids);

    /**
     * 删除接管类型信息
     * 
     * @param id 接管类型主键
     * @return 结果
     */
    public int deleteUPipelineById(Long id);
}
