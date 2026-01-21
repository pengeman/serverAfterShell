package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Plate;

/**
 * 板片信息Service接口
 * 
 * @author pengweitao
 * @date 2025-12-16
 */
public interface IPlateService 
{
    /**
     * 查询板片信息
     * 
     * @param id 板片信息主键
     * @return 板片信息
     */
    public Plate selectPlateById(Long id);

    /**
     * 查询板片信息列表
     * 
     * @param plate 板片信息
     * @return 板片信息集合
     */
    public List<Plate> selectPlateList(Plate plate);

    /**
     * 新增板片信息
     * 
     * @param plate 板片信息
     * @return 结果
     */
    public int insertPlate(Plate plate);

    /**
     * 修改板片信息
     * 
     * @param plate 板片信息
     * @return 结果
     */
    public int updatePlate(Plate plate);

    /**
     * 批量删除板片信息
     * 
     * @param ids 需要删除的板片信息主键集合
     * @return 结果
     */
    public int deletePlateByIds(String ids);

    /**
     * 删除板片信息信息
     * 
     * @param id 板片信息主键
     * @return 结果
     */
    public int deletePlateById(Long id);
}
