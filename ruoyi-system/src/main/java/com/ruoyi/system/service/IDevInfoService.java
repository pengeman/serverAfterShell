package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.DevInfo;

/**
 * 设备信息档案Service接口
 * 
 * @author pengweitao
 * @date 2026-01-21
 */
public interface IDevInfoService 
{
    /**
     * 查询设备信息档案
     * 
     * @param id 设备信息档案主键
     * @return 设备信息档案
     */
    public DevInfo selectDevInfoById(Long id);

    /**
     * 查询设备信息档案列表
     * 
     * @param devInfo 设备信息档案
     * @return 设备信息档案集合
     */
    public List<DevInfo> selectDevInfoList(DevInfo devInfo);

    /**
     * 新增设备信息档案
     * 
     * @param devInfo 设备信息档案
     * @return 结果
     */
    public int insertDevInfo(DevInfo devInfo);

    /**
     * 修改设备信息档案
     * 
     * @param devInfo 设备信息档案
     * @return 结果
     */
    public int updateDevInfo(DevInfo devInfo);

    /**
     * 批量删除设备信息档案
     * 
     * @param ids 需要删除的设备信息档案主键集合
     * @return 结果
     */
    public int deleteDevInfoByIds(String ids);

    /**
     * 删除设备信息档案信息
     * 
     * @param id 设备信息档案主键
     * @return 结果
     */
    public int deleteDevInfoById(Long id);
}
