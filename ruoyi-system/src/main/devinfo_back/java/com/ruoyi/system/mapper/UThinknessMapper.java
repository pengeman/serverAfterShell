package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.UThinkness;

/**
 * 板片厚度Mapper接口
 * 
 * @author pengweitao
 * @date 2025-06-28
 */
public interface UThinknessMapper 
{
    /**
     * 查询板片厚度
     * 
     * @param id 板片厚度主键
     * @return 板片厚度
     */
    public UThinkness selectUThinknessById(Long id);

    /**
     * 查询板片厚度列表
     * 
     * @param uThinkness 板片厚度
     * @return 板片厚度集合
     */
    public List<UThinkness> selectUThinknessList(UThinkness uThinkness);

    /**
     * 新增板片厚度
     * 
     * @param uThinkness 板片厚度
     * @return 结果
     */
    public int insertUThinkness(UThinkness uThinkness);

    /**
     * 修改板片厚度
     * 
     * @param uThinkness 板片厚度
     * @return 结果
     */
    public int updateUThinkness(UThinkness uThinkness);

    /**
     * 删除板片厚度
     * 
     * @param id 板片厚度主键
     * @return 结果
     */
    public int deleteUThinknessById(Long id);

    /**
     * 批量删除板片厚度
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUThinknessByIds(String[] ids);
}
