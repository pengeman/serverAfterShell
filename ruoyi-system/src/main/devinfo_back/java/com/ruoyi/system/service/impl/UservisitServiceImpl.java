package com.ruoyi.system.service.impl;

import java.util.Collections;
import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.domain.Userinfo;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.IUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UservisitMapper;
import com.ruoyi.system.domain.Uservisit;
import com.ruoyi.system.service.IUservisitService;
import com.ruoyi.common.core.text.Convert;

/**
 * 客户分配Service业务层处理
 * 
 * @author pengweitao
 * @date 2025-01-12
 */
@Service
public class UservisitServiceImpl implements IUservisitService 
{
    @Autowired
    private UservisitMapper uservisitMapper;
    @Autowired
    private IUserinfoService userinfoService;
    @Autowired
    private ISysUserService sysUserService;

    /**
     * 查询客户分配
     * 
     * @param id 客户分配主键
     * @return 客户分配
     */
    @Override
    public Uservisit selectUservisitById(Long id)
    {
        return uservisitMapper.selectUservisitById(id);
    }

    /**
     * 查询客户分配列表
     * 
     * @param uservisit 客户分配
     * @return 客户分配
     */
    @Override
    public List<Uservisit> selectUservisitList(Uservisit uservisit)
    {
        return uservisitMapper.selectUservisitList(uservisit);
    }

    /**
     * 新增客户分配
     * 
     * @param uservisit 客户分配
     * @return 结果
     */
    @Override
    public int insertUservisit(Uservisit uservisit)
    {
        return uservisitMapper.insertUservisit(uservisit);
    }

    /**
     * 修改客户分配
     * 
     * @param uservisit 客户分配
     * @return 结果
     */
    @Override
    public int updateUservisit(Uservisit uservisit)
    {
        return uservisitMapper.updateUservisit(uservisit);
    }

    /**
     * 批量删除客户分配
     * 
     * @param ids 需要删除的客户分配主键
     * @return 结果
     */
    @Override
    public int deleteUservisitByIds(String ids)
    {
        return uservisitMapper.deleteUservisitByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除客户分配信息
     * 
     * @param id 客户分配主键
     * @return 结果
     */
    @Override
    public int deleteUservisitById(Long id)
    {
        return uservisitMapper.deleteUservisitById(id);
    }

    @Override
    public List<Userinfo> selectUserinfo(Userinfo userinfo) {
        List<Userinfo> userinfoList = userinfoService.selectUserinfoList(userinfo);
        return userinfoList;
    }

    @Override
    public List<SysUser> selectSysUser(SysUser sysUser) {
        List<SysUser> sysUserList = sysUserService.selectUserList(sysUser);
        return sysUserList;
    }
}
