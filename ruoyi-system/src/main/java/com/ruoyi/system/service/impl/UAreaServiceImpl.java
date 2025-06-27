package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UAreaMapper;
import com.ruoyi.system.domain.UArea;
import com.ruoyi.system.service.IUAreaService;
import com.ruoyi.common.core.text.Convert;

/**
 * 单板面积Service业务层处理
 * 
 * @author pengweitao
 * @date 2025-06-27
 */
@Service
public class UAreaServiceImpl implements IUAreaService 
{
    @Autowired
    private UAreaMapper uAreaMapper;

    /**
     * 查询单板面积
     * 
     * @param id 单板面积主键
     * @return 单板面积
     */
    @Override
    public UArea selectUAreaById(Long id)
    {
        return uAreaMapper.selectUAreaById(id);
    }

    /**
     * 查询单板面积列表
     * 
     * @param uArea 单板面积
     * @return 单板面积
     */
    @Override
    public List<UArea> selectUAreaList(UArea uArea)
    {
        return uAreaMapper.selectUAreaList(uArea);
    }

    /**
     * 新增单板面积
     * 
     * @param uArea 单板面积
     * @return 结果
     */
    @Override
    public int insertUArea(UArea uArea)
    {
        return uAreaMapper.insertUArea(uArea);
    }

    /**
     * 修改单板面积
     * 
     * @param uArea 单板面积
     * @return 结果
     */
    @Override
    public int updateUArea(UArea uArea)
    {
        return uAreaMapper.updateUArea(uArea);
    }

    /**
     * 批量删除单板面积
     * 
     * @param ids 需要删除的单板面积主键
     * @return 结果
     */
    @Override
    public int deleteUAreaByIds(String ids)
    {
        return uAreaMapper.deleteUAreaByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除单板面积信息
     * 
     * @param id 单板面积主键
     * @return 结果
     */
    @Override
    public int deleteUAreaById(Long id)
    {
        return uAreaMapper.deleteUAreaById(id);
    }
}
