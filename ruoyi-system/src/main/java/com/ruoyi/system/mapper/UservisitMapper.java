package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Uservisit;

/**
 * 用户访问记录，展现末尾记录Mapper接口
 * 
 * @author pengweitao
 * @date 2025-01-09
 */
public interface UservisitMapper 
{
    /**
     * 查询用户访问记录，展现末尾记录
     * 
     * @param id 用户访问记录，展现末尾记录主键
     * @return 用户访问记录，展现末尾记录
     */
    public Uservisit selectUservisitById(Long id);

    /**
     * 查询用户访问记录，展现末尾记录列表
     * 
     * @param uservisit 用户访问记录，展现末尾记录
     * @return 用户访问记录，展现末尾记录集合
     */
    public List<Uservisit> selectUservisitList(Uservisit uservisit);

    /**
     * 新增用户访问记录，展现末尾记录
     * 
     * @param uservisit 用户访问记录，展现末尾记录
     * @return 结果
     */
    public int insertUservisit(Uservisit uservisit);

    /**
     * 修改用户访问记录，展现末尾记录
     * 
     * @param uservisit 用户访问记录，展现末尾记录
     * @return 结果
     */
    public int updateUservisit(Uservisit uservisit);

    /**
     * 删除用户访问记录，展现末尾记录
     * 
     * @param id 用户访问记录，展现末尾记录主键
     * @return 结果
     */
    public int deleteUservisitById(Long id);

    /**
     * 批量删除用户访问记录，展现末尾记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUservisitByIds(String[] ids);
}
