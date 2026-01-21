package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.domain.Userinfo;
import com.ruoyi.system.domain.Uservisit;

/**
 * 客户分配Service接口
 * 
 * @author pengweitao
 * @date 2025-01-12
 */
public interface IUservisitService 
{
    /**
     * 查询客户分配
     * 
     * @param id 客户分配主键
     * @return 客户分配
     */
    public Uservisit selectUservisitById(Long id);

    /**
     * 查询客户分配列表
     * 
     * @param uservisit 客户分配
     * @return 客户分配集合
     */
    public List<Uservisit> selectUservisitList(Uservisit uservisit);

    /**
     * 新增客户分配
     * 
     * @param uservisit 客户分配
     * @return 结果
     */
    public int insertUservisit(Uservisit uservisit);

    /**
     * 修改客户分配
     * 
     * @param uservisit 客户分配
     * @return 结果
     */
    public int updateUservisit(Uservisit uservisit);

    /**
     * 批量删除客户分配
     * 
     * @param ids 需要删除的客户分配主键集合
     * @return 结果
     */
    public int deleteUservisitByIds(String ids);

    /**
     * 删除客户分配信息
     * 
     * @param id 客户分配主键
     * @return 结果
     */
    public int deleteUservisitById(Long id);

    /**
     * 查询客户信息 userinfo
     */
    public List<Userinfo> selectUserinfo(Userinfo userinfo);

    /**
     * 查询销售信息 sys_user
     */
    public List<SysUser> selectSysUser(SysUser sysuser);
}
