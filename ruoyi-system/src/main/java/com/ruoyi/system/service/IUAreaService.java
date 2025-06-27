package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.UArea;

/**
 * 单板面积Service接口
 * 
 * @author pengweitao
 * @date 2025-06-27
 */
public interface IUAreaService 
{
    /**
     * 查询单板面积
     * 
     * @param id 单板面积主键
     * @return 单板面积
     */
    public UArea selectUAreaById(Long id);

    /**
     * 查询单板面积列表
     * 
     * @param uArea 单板面积
     * @return 单板面积集合
     */
    public List<UArea> selectUAreaList(UArea uArea);

    /**
     * 新增单板面积
     * 
     * @param uArea 单板面积
     * @return 结果
     */
    public int insertUArea(UArea uArea);

    /**
     * 修改单板面积
     * 
     * @param uArea 单板面积
     * @return 结果
     */
    public int updateUArea(UArea uArea);

    /**
     * 批量删除单板面积
     * 
     * @param ids 需要删除的单板面积主键集合
     * @return 结果
     */
    public int deleteUAreaByIds(String ids);

    /**
     * 删除单板面积信息
     * 
     * @param id 单板面积主键
     * @return 结果
     */
    public int deleteUAreaById(Long id);
}
