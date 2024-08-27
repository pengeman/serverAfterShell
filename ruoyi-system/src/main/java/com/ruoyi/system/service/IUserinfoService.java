package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Userinfo;

/**
 * 用户信息Service接口
 * 
 * @author pengweitao
 * @date 2024-08-27
 */
public interface IUserinfoService 
{
    /**
     * 查询用户信息
     * 
     * @param id 用户信息主键
     * @return 用户信息
     */
    public Userinfo selectUserinfoById(Long id);

    /**
     * 查询用户信息列表
     * 
     * @param userinfo 用户信息
     * @return 用户信息集合
     */
    public List<Userinfo> selectUserinfoList(Userinfo userinfo);

    /**
     * 新增用户信息
     * 
     * @param userinfo 用户信息
     * @return 结果
     */
    public int insertUserinfo(Userinfo userinfo);

    /**
     * 修改用户信息
     * 
     * @param userinfo 用户信息
     * @return 结果
     */
    public int updateUserinfo(Userinfo userinfo);

    /**
     * 批量删除用户信息
     * 
     * @param ids 需要删除的用户信息主键集合
     * @return 结果
     */
    public int deleteUserinfoByIds(String ids);

    /**
     * 删除用户信息信息
     * 
     * @param id 用户信息主键
     * @return 结果
     */
    public int deleteUserinfoById(Long id);
}
