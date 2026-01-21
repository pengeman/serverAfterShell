package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ParrotMapper;
import com.ruoyi.system.domain.Parrot;
import com.ruoyi.system.service.IParrotService;
import com.ruoyi.common.core.text.Convert;

/**
 * 鹦鹉财务Service业务层处理
 * 
 * @author pengweitao
 * @date 2024-08-23
 */
@Service
public class ParrotServiceImpl implements IParrotService 
{
    @Autowired
    private ParrotMapper parrotMapper;

    /**
     * 查询鹦鹉财务
     * 
     * @param id 鹦鹉财务主键
     * @return 鹦鹉财务
     */
    @Override
    public Parrot selectParrotById(Long id)
    {
        return parrotMapper.selectParrotById(id);
    }

    /**
     * 查询鹦鹉财务列表
     * 
     * @param parrot 鹦鹉财务
     * @return 鹦鹉财务
     */
    @Override
    public List<Parrot> selectParrotList(Parrot parrot)
    {
        return parrotMapper.selectParrotList(parrot);
    }

    /**
     * 新增鹦鹉财务
     * 
     * @param parrot 鹦鹉财务
     * @return 结果
     */
    @Override
    public int insertParrot(Parrot parrot)
    {
        parrot.setCreateTime(DateUtils.getNowDate());
        return parrotMapper.insertParrot(parrot);
    }

    /**
     * 修改鹦鹉财务
     * 
     * @param parrot 鹦鹉财务
     * @return 结果
     */
    @Override
    public int updateParrot(Parrot parrot)
    {
        return parrotMapper.updateParrot(parrot);
    }

    /**
     * 批量删除鹦鹉财务
     * 
     * @param ids 需要删除的鹦鹉财务主键
     * @return 结果
     */
    @Override
    public int deleteParrotByIds(String ids)
    {
        return parrotMapper.deleteParrotByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除鹦鹉财务信息
     * 
     * @param id 鹦鹉财务主键
     * @return 结果
     */
    @Override
    public int deleteParrotById(Long id)
    {
        return parrotMapper.deleteParrotById(id);
    }
}
