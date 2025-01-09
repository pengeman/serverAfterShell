package com.ruoyi.system.service;

import java.util.LinkedHashMap;
import java.util.List;
import com.ruoyi.system.domain.DevInfo;
import com.ruoyi.system.domain.Buyerinfo;
import com.ruoyi.system.domain.Userinfo;

/**
 * 设备档案Service接口
 * 
 * @author pengweitao
 * @date 2024-08-22
 */
public interface IDevInfoService 
{
    /**
     * 查询设备档案
     * 
     * @param id 设备档案主键
     * @return 设备档案
     */
    public DevInfo selectDevInfoById(Long id);

    /**
     * 查询设备档案列表
     * 
     * @param devInfo 设备档案
     * @return 设备档案集合
     */
    public List<DevInfo> selectDevInfoList(DevInfo devInfo);

    /**
     * 新增设备档案
     * 
     * @param devInfo 设备档案
     * @return 结果
     */
    public int insertDevInfo(DevInfo devInfo);

    /**
     * 修改设备档案
     * 
     * @param devInfo 设备档案
     * @return 结果
     */
    public int updateDevInfo(DevInfo devInfo);

    /**
     * 批量删除设备档案
     * 
     * @param ids 需要删除的设备档案主键集合
     * @return 结果
     */
    public int deleteDevInfoByIds(String ids);

    /**
     * 删除设备档案信息
     * 
     * @param id 设备档案主键
     * @return 结果
     */
    public int deleteDevInfoById(Long id);

    /**
     * 新增设备档案   事务
     * 同时新增购买方档案和用户信息
     * @param devInfo
     * @param buyerinfo
     * @param userInfo
     * @return
     */
    public int insetDevInfoGroup(DevInfo devInfo, Buyerinfo buyerinfo, Userinfo userInfo);

    public List<LinkedHashMap<String, Object>> selectDevInfoList2(DevInfo devInfo);
}
