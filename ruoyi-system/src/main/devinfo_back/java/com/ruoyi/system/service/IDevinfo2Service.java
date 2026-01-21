package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Devinfo2;

/**
 * 设备信息明细Service接口
 * 
 * @author pengweitao
 * @date 2024-08-22
 */
public interface IDevinfo2Service 
{
    /**
     * 查询设备信息明细
     * 
     * @param id 设备信息明细主键
     * @return 设备信息明细
     */
    public Devinfo2 selectDevinfo2ById(Long id);

    /**
     * 查询设备信息明细列表
     * 
     * @param devinfo2 设备信息明细
     * @return 设备信息明细集合
     */
    public List<Devinfo2> selectDevinfo2List(Devinfo2 devinfo2);

    /**
     * 新增设备信息明细
     * 
     * @param devinfo2 设备信息明细
     * @return 结果
     */
    public int insertDevinfo2(Devinfo2 devinfo2);

    /**
     * 修改设备信息明细
     * 
     * @param devinfo2 设备信息明细
     * @return 结果
     */
    public int updateDevinfo2(Devinfo2 devinfo2);

    /**
     * 批量删除设备信息明细
     * 
     * @param ids 需要删除的设备信息明细主键集合
     * @return 结果
     */
    public int deleteDevinfo2ByIds(String ids);

    /**
     * 删除设备信息明细信息
     * 
     * @param id 设备信息明细主键
     * @return 结果
     */
    public int deleteDevinfo2ById(Long id);
}
