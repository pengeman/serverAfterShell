package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UserinfoMapper;
import com.ruoyi.system.domain.Userinfo;
import com.ruoyi.system.service.IUserinfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户信息Service业务层处理
 * 
 * @author pengweitao
 * @date 2024-08-27
 */
@Service
public class UserinfoServiceImpl implements IUserinfoService 
{
    @Autowired
    private UserinfoMapper userinfoMapper;

    /**
     * 查询用户信息
     * 
     * @param id 用户信息主键
     * @return 用户信息
     */
    @Override
    public Userinfo selectUserinfoById(Long id)
    {
        return userinfoMapper.selectUserinfoById(id);
    }

    /**
     * 查询用户信息列表
     * 
     * @param userinfo 用户信息
     * @return 用户信息
     */
    @Override
    public List<Userinfo> selectUserinfoList(Userinfo userinfo)
    {
        return userinfoMapper.selectUserinfoList(userinfo);
    }

    /**
     * 新增用户信息
     * 
     * @param userinfo 用户信息
     * @return 结果:新插入记录的id值
     */
    @Override
    public int insertUserinfo(Userinfo userinfo)
    {
        userinfo.setCreateTime(DateUtils.getNowDate());
        userinfoMapper.insertUserinfo(userinfo);
        Long id = userinfo.getId();
        return id.intValue();
    }

    /**
     * 修改用户信息
     * 
     * @param userinfo 用户信息
     * @return 结果
     */
    @Override
    public int updateUserinfo(Userinfo userinfo)
    {
        userinfo.setUpdateTime(DateUtils.getNowDate());
        return userinfoMapper.updateUserinfo(userinfo);
    }

    /**
     * 批量删除用户信息
     * 
     * @param ids 需要删除的用户信息主键
     * @return 结果
     */
    @Override
    public int deleteUserinfoByIds(String ids)
    {
        return userinfoMapper.deleteUserinfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户信息信息
     * 
     * @param id 用户信息主键
     * @return 结果
     */
    @Override
    public int deleteUserinfoById(Long id)
    {
        return userinfoMapper.deleteUserinfoById(id);
    }
}
