package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UFlange2Mapper;
import com.ruoyi.system.domain.UFlange2;
import com.ruoyi.system.service.IUFlange2Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 法兰-JB/T81-94国标Service业务层处理
 * 
 * @author pengweitao
 * @date 2025-06-27
 */
@Service
public class UFlange2ServiceImpl implements IUFlange2Service 
{
    @Autowired
    private UFlange2Mapper uFlange2Mapper;

    /**
     * 查询法兰-JB/T81-94国标
     * 
     * @param id 法兰-JB/T81-94国标主键
     * @return 法兰-JB/T81-94国标
     */
    @Override
    public UFlange2 selectUFlange2ById(Long id)
    {
        return uFlange2Mapper.selectUFlange2ById(id);
    }

    /**
     * 查询法兰-JB/T81-94国标列表
     * 
     * @param uFlange2 法兰-JB/T81-94国标
     * @return 法兰-JB/T81-94国标
     */
    @Override
    public List<UFlange2> selectUFlange2List(UFlange2 uFlange2)
    {
        return uFlange2Mapper.selectUFlange2List(uFlange2);
    }

    /**
     * 新增法兰-JB/T81-94国标
     * 
     * @param uFlange2 法兰-JB/T81-94国标
     * @return 结果
     */
    @Override
    public int insertUFlange2(UFlange2 uFlange2)
    {
        return uFlange2Mapper.insertUFlange2(uFlange2);
    }

    /**
     * 修改法兰-JB/T81-94国标
     * 
     * @param uFlange2 法兰-JB/T81-94国标
     * @return 结果
     */
    @Override
    public int updateUFlange2(UFlange2 uFlange2)
    {
        return uFlange2Mapper.updateUFlange2(uFlange2);
    }

    /**
     * 批量删除法兰-JB/T81-94国标
     * 
     * @param ids 需要删除的法兰-JB/T81-94国标主键
     * @return 结果
     */
    @Override
    public int deleteUFlange2ByIds(String ids)
    {
        return uFlange2Mapper.deleteUFlange2ByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除法兰-JB/T81-94国标信息
     * 
     * @param id 法兰-JB/T81-94国标主键
     * @return 结果
     */
    @Override
    public int deleteUFlange2ById(Long id)
    {
        return uFlange2Mapper.deleteUFlange2ById(id);
    }
}
