package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.Devinfo2Mapper;
import com.ruoyi.system.domain.Devinfo2;
import com.ruoyi.system.service.IDevinfo2Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 设备信息明细Service业务层处理
 * 
 * @author pengweitao
 * @date 2024-08-22
 */
@Service
public class Devinfo2ServiceImpl implements IDevinfo2Service 
{
    @Autowired
    private Devinfo2Mapper devinfo2Mapper;

    /**
     * 查询设备信息明细
     * 
     * @param id 设备信息明细主键
     * @return 设备信息明细
     */
    @Override
    public Devinfo2 selectDevinfo2ById(Long id)
    {
        return devinfo2Mapper.selectDevinfo2ById(id);
    }

    /**
     * 查询设备信息明细列表
     * 
     * @param devinfo2 设备信息明细
     * @return 设备信息明细
     */
    @Override
    public List<Devinfo2> selectDevinfo2List(Devinfo2 devinfo2)
    {
        return devinfo2Mapper.selectDevinfo2List(devinfo2);
    }

    /**
     * 新增设备信息明细
     * 
     * @param devinfo2 设备信息明细
     * @return 结果
     */
    @Override
    public int insertDevinfo2(Devinfo2 devinfo2)
    {
        return devinfo2Mapper.insertDevinfo2(devinfo2);
    }

    /**
     * 修改设备信息明细
     * 
     * @param devinfo2 设备信息明细
     * @return 结果
     */
    @Override
    public int updateDevinfo2(Devinfo2 devinfo2)
    {
        return devinfo2Mapper.updateDevinfo2(devinfo2);
    }

    /**
     * 批量删除设备信息明细
     * 
     * @param ids 需要删除的设备信息明细主键
     * @return 结果
     */
    @Override
    public int deleteDevinfo2ByIds(String ids)
    {
        return devinfo2Mapper.deleteDevinfo2ByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备信息明细信息
     * 
     * @param id 设备信息明细主键
     * @return 结果
     */
    @Override
    public int deleteDevinfo2ById(Long id)
    {
        return devinfo2Mapper.deleteDevinfo2ById(id);
    }
}
