package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UThinknessMapper;
import com.ruoyi.system.domain.UThinkness;
import com.ruoyi.system.service.IUThinknessService;
import com.ruoyi.common.core.text.Convert;

/**
 * 板片厚度Service业务层处理
 * 
 * @author pengweitao
 * @date 2025-06-28
 */
@Service
public class UThinknessServiceImpl implements IUThinknessService 
{
    @Autowired
    private UThinknessMapper uThinknessMapper;

    /**
     * 查询板片厚度
     * 
     * @param id 板片厚度主键
     * @return 板片厚度
     */
    @Override
    public UThinkness selectUThinknessById(Long id)
    {
        return uThinknessMapper.selectUThinknessById(id);
    }

    /**
     * 查询板片厚度列表
     * 
     * @param uThinkness 板片厚度
     * @return 板片厚度
     */
    @Override
    public List<UThinkness> selectUThinknessList(UThinkness uThinkness)
    {
        return uThinknessMapper.selectUThinknessList(uThinkness);
    }

    /**
     * 新增板片厚度
     * 
     * @param uThinkness 板片厚度
     * @return 结果
     */
    @Override
    public int insertUThinkness(UThinkness uThinkness)
    {
        return uThinknessMapper.insertUThinkness(uThinkness);
    }

    /**
     * 修改板片厚度
     * 
     * @param uThinkness 板片厚度
     * @return 结果
     */
    @Override
    public int updateUThinkness(UThinkness uThinkness)
    {
        return uThinknessMapper.updateUThinkness(uThinkness);
    }

    /**
     * 批量删除板片厚度
     * 
     * @param ids 需要删除的板片厚度主键
     * @return 结果
     */
    @Override
    public int deleteUThinknessByIds(String ids)
    {
        return uThinknessMapper.deleteUThinknessByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除板片厚度信息
     * 
     * @param id 板片厚度主键
     * @return 结果
     */
    @Override
    public int deleteUThinknessById(Long id)
    {
        return uThinknessMapper.deleteUThinknessById(id);
    }
}
