package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UFlange1Mapper;
import com.ruoyi.system.domain.UFlange1;
import com.ruoyi.system.service.IUFlange1Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 法兰-HG/T20592-09化工Service业务层处理
 * 
 * @author pengweitao
 * @date 2025-06-27
 */
@Service
public class UFlange1ServiceImpl implements IUFlange1Service 
{
    @Autowired
    private UFlange1Mapper uFlange1Mapper;

    /**
     * 查询法兰-HG/T20592-09化工
     * 
     * @param id 法兰-HG/T20592-09化工主键
     * @return 法兰-HG/T20592-09化工
     */
    @Override
    public UFlange1 selectUFlange1ById(Long id)
    {
        return uFlange1Mapper.selectUFlange1ById(id);
    }

    /**
     * 查询法兰-HG/T20592-09化工列表
     * 
     * @param uFlange1 法兰-HG/T20592-09化工
     * @return 法兰-HG/T20592-09化工
     */
    @Override
    public List<UFlange1> selectUFlange1List(UFlange1 uFlange1)
    {
        return uFlange1Mapper.selectUFlange1List(uFlange1);
    }

    /**
     * 新增法兰-HG/T20592-09化工
     * 
     * @param uFlange1 法兰-HG/T20592-09化工
     * @return 结果
     */
    @Override
    public int insertUFlange1(UFlange1 uFlange1)
    {
        return uFlange1Mapper.insertUFlange1(uFlange1);
    }

    /**
     * 修改法兰-HG/T20592-09化工
     * 
     * @param uFlange1 法兰-HG/T20592-09化工
     * @return 结果
     */
    @Override
    public int updateUFlange1(UFlange1 uFlange1)
    {
        return uFlange1Mapper.updateUFlange1(uFlange1);
    }

    /**
     * 批量删除法兰-HG/T20592-09化工
     * 
     * @param ids 需要删除的法兰-HG/T20592-09化工主键
     * @return 结果
     */
    @Override
    public int deleteUFlange1ByIds(String ids)
    {
        return uFlange1Mapper.deleteUFlange1ByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除法兰-HG/T20592-09化工信息
     * 
     * @param id 法兰-HG/T20592-09化工主键
     * @return 结果
     */
    @Override
    public int deleteUFlange1ById(Long id)
    {
        return uFlange1Mapper.deleteUFlange1ById(id);
    }
}
