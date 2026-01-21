package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PlateMapper;
import com.ruoyi.system.domain.Plate;
import com.ruoyi.system.service.IPlateService;
import com.ruoyi.common.core.text.Convert;

/**
 * 板片信息Service业务层处理
 * 
 * @author pengweitao
 * @date 2025-12-16
 */
@Service
public class PlateServiceImpl implements IPlateService 
{
    @Autowired
    private PlateMapper plateMapper;

    /**
     * 查询板片信息
     * 
     * @param id 板片信息主键
     * @return 板片信息
     */
    @Override
    public Plate selectPlateById(Long id)
    {
        return plateMapper.selectPlateById(id);
    }

    /**
     * 查询板片信息列表
     * 
     * @param plate 板片信息
     * @return 板片信息
     */
    @Override
    public List<Plate> selectPlateList(Plate plate)
    {
        return plateMapper.selectPlateList(plate);
    }

    /**
     * 新增板片信息
     * 
     * @param plate 板片信息
     * @return 结果
     */
    @Override
    public int insertPlate(Plate plate)
    {
        return plateMapper.insertPlate(plate);
    }

    /**
     * 修改板片信息
     * 
     * @param plate 板片信息
     * @return 结果
     */
    @Override
    public int updatePlate(Plate plate)
    {
        return plateMapper.updatePlate(plate);
    }

    /**
     * 批量删除板片信息
     * 
     * @param ids 需要删除的板片信息主键
     * @return 结果
     */
    @Override
    public int deletePlateByIds(String ids)
    {
        return plateMapper.deletePlateByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除板片信息信息
     * 
     * @param id 板片信息主键
     * @return 结果
     */
    @Override
    public int deletePlateById(Long id)
    {
        return plateMapper.deletePlateById(id);
    }
}
