package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Parrot;

/**
 * 鹦鹉财务Mapper接口
 * 
 * @author pengweitao
 * @date 2024-08-23
 */
public interface ParrotMapper 
{
    /**
     * 查询鹦鹉财务
     * 
     * @param id 鹦鹉财务主键
     * @return 鹦鹉财务
     */
    public Parrot selectParrotById(Long id);

    /**
     * 查询鹦鹉财务列表
     * 
     * @param parrot 鹦鹉财务
     * @return 鹦鹉财务集合
     */
    public List<Parrot> selectParrotList(Parrot parrot);

    /**
     * 新增鹦鹉财务
     * 
     * @param parrot 鹦鹉财务
     * @return 结果
     */
    public int insertParrot(Parrot parrot);

    /**
     * 修改鹦鹉财务
     * 
     * @param parrot 鹦鹉财务
     * @return 结果
     */
    public int updateParrot(Parrot parrot);

    /**
     * 删除鹦鹉财务
     * 
     * @param id 鹦鹉财务主键
     * @return 结果
     */
    public int deleteParrotById(Long id);

    /**
     * 批量删除鹦鹉财务
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteParrotByIds(String[] ids);
}
