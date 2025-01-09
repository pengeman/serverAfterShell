package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UservisitMapper;
import com.ruoyi.system.domain.Uservisit;
import com.ruoyi.system.service.IUservisitService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户访问记录，展现末尾记录Service业务层处理
 * 
 * @author pengweitao
 * @date 2025-01-09
 */
@Service
public class UservisitServiceImpl implements IUservisitService 
{
    @Autowired
    private UservisitMapper uservisitMapper;

    /**
     * 查询用户访问记录，展现末尾记录
     * 
     * @param id 用户访问记录，展现末尾记录主键
     * @return 用户访问记录，展现末尾记录
     */
    @Override
    public Uservisit selectUservisitById(Long id)
    {
        return uservisitMapper.selectUservisitById(id);
    }

    /**
     * 查询用户访问记录，展现末尾记录列表
     * 
     * @param uservisit 用户访问记录，展现末尾记录
     * @return 用户访问记录，展现末尾记录
     */
    @Override
    public List<Uservisit> selectUservisitList(Uservisit uservisit)
    {
        return uservisitMapper.selectUservisitList(uservisit);
    }

    /**
     * 新增用户访问记录，展现末尾记录
     * 
     * @param uservisit 用户访问记录，展现末尾记录
     * @return 结果
     */
    @Override
    public int insertUservisit(Uservisit uservisit)
    {
        return uservisitMapper.insertUservisit(uservisit);
    }

    /**
     * 修改用户访问记录，展现末尾记录
     * 
     * @param uservisit 用户访问记录，展现末尾记录
     * @return 结果
     */
    @Override
    public int updateUservisit(Uservisit uservisit)
    {
        return uservisitMapper.updateUservisit(uservisit);
    }

    /**
     * 批量删除用户访问记录，展现末尾记录
     * 
     * @param ids 需要删除的用户访问记录，展现末尾记录主键
     * @return 结果
     */
    @Override
    public int deleteUservisitByIds(String ids)
    {
        return uservisitMapper.deleteUservisitByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户访问记录，展现末尾记录信息
     * 
     * @param id 用户访问记录，展现末尾记录主键
     * @return 结果
     */
    @Override
    public int deleteUservisitById(Long id)
    {
        return uservisitMapper.deleteUservisitById(id);
    }
}
