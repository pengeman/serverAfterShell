package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.AftersalesBack;

/**
 * 售后派工单备份Service接口
 * 
 * @author peng
 * @date 2024-07-27
 */
public interface IAftersalesBackService 
{
    /**
     * 查询售后派工单备份
     * 
     * @param id 售后派工单备份主键
     * @return 售后派工单备份
     */
    public AftersalesBack selectAftersalesBackById(Long id);

    /**
     * 查询售后派工单备份列表
     * 
     * @param aftersalesBack 售后派工单备份
     * @return 售后派工单备份集合
     */
    public List<AftersalesBack> selectAftersalesBackList(AftersalesBack aftersalesBack);

    /**
     * 新增售后派工单备份
     * 
     * @param aftersalesBack 售后派工单备份
     * @return 结果
     */
    public int insertAftersalesBack(AftersalesBack aftersalesBack);

    /**
     * 修改售后派工单备份
     * 
     * @param aftersalesBack 售后派工单备份
     * @return 结果
     */
    public int updateAftersalesBack(AftersalesBack aftersalesBack);

    /**
     * 批量删除售后派工单备份
     * 
     * @param ids 需要删除的售后派工单备份主键集合
     * @return 结果
     */
    public int deleteAftersalesBackByIds(String ids);

    /**
     * 删除售后派工单备份信息
     * 
     * @param id 售后派工单备份主键
     * @return 结果
     */
    public int deleteAftersalesBackById(Long id);

    /**
     *
     * @param id
     * @return
     */
    @Deprecated
    public int gopassAfterSales(Long id);
}
