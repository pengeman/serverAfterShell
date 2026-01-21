package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.USheetMapper;
import com.ruoyi.system.domain.USheet;
import com.ruoyi.system.service.IUSheetService;
import com.ruoyi.common.core.text.Convert;

/**
 * 板片Service业务层处理
 * 
 * @author pengweitao
 * @date 2025-06-28
 */
@Service
public class USheetServiceImpl implements IUSheetService 
{
    @Autowired
    private USheetMapper uSheetMapper;

    /**
     * 查询板片
     * 
     * @param id 板片主键
     * @return 板片
     */
    @Override
    public USheet selectUSheetById(Long id)
    {
        return uSheetMapper.selectUSheetById(id);
    }

    /**
     * 查询板片列表
     * 
     * @param uSheet 板片
     * @return 板片
     */
    @Override
    public List<USheet> selectUSheetList(USheet uSheet)
    {
        return uSheetMapper.selectUSheetList(uSheet);
    }

    /**
     * 新增板片
     * 
     * @param uSheet 板片
     * @return 结果
     */
    @Override
    public int insertUSheet(USheet uSheet)
    {
        return uSheetMapper.insertUSheet(uSheet);
    }

    /**
     * 修改板片
     * 
     * @param uSheet 板片
     * @return 结果
     */
    @Override
    public int updateUSheet(USheet uSheet)
    {
        return uSheetMapper.updateUSheet(uSheet);
    }

    /**
     * 批量删除板片
     * 
     * @param ids 需要删除的板片主键
     * @return 结果
     */
    @Override
    public int deleteUSheetByIds(String ids)
    {
        return uSheetMapper.deleteUSheetByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除板片信息
     * 
     * @param id 板片主键
     * @return 结果
     */
    @Override
    public int deleteUSheetById(Long id)
    {
        return uSheetMapper.deleteUSheetById(id);
    }
}
