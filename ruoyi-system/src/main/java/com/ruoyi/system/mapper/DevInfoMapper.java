package com.ruoyi.system.mapper;

import java.util.LinkedHashMap;
import java.util.List;
import com.ruoyi.system.domain.DevInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 设备档案Mapper接口
 * 
 * @author pengweitao
 * @date 2024-08-22
 */
public interface DevInfoMapper 
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
     * 删除设备档案
     * 
     * @param id 设备档案主键
     * @return 结果
     */
    public int deleteDevInfoById(Long id);

    /**
     * 批量删除设备档案
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDevInfoByIds(String[] ids);

    @Select("${sqlStr}")
    List<LinkedHashMap<String,Object>> selectDev2(@Param(value = "sqlStr") String sqlStr);

}
